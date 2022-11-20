import java.util.Scanner;
abstract class Sushi {
    public void makeSushi() {}
    public void pourSauce() {}
    public void AddEvenMoreSauce() {}
}

enum SushiType {
    BLACK_NIGIRI,
    GIANT_MAKI,
    LAMP_URAMAKI,
    KAMELUK_SASHIMI
}

class OuterWildsNigiri extends Sushi {
    @Override
    public void AddEvenMoreSauce() {
        System.out.println ("Додамо до нашого нігірі соус з Чорного Терновику..");
    }
}

class OuterWildsMaki extends Sushi {
    @Override
    public void AddEvenMoreSauce() {
        System.out.println ("Додамо до нашого макі настійки з Пучини Гіганту..");
    }
}

class OuterWildsUramaki extends Sushi {
    @Override
    public void AddEvenMoreSauce() {
        System.out.println ("Додамо до нашого урамакі імбірного соусу з Пустотної Лампи...");
    }
}

class OuterWildsSashimi extends Sushi {
    @Override
    public void AddEvenMoreSauce() {
        System.out.println ("Прекрасний сашімі з водною настійкою з Камельку..");
    }
}

abstract class SushiShop {
    public Sushi orderSushi (SushiType type) {

        Sushi sushi = createSushi (type);
        sushi.makeSushi();
        sushi.pourSauce();

        sushi.AddEvenMoreSauce();
        System.out.println ('\n' + "Насолоджуйтеся!");
        return sushi;
    }
    protected abstract Sushi createSushi (SushiType type);
}

class OuterWildsSushiShop extends SushiShop {
    @Override
    public Sushi createSushi (SushiType type) {
        Sushi sushi = switch (type) {
            case KAMELUK_SASHIMI -> new OuterWildsSashimi();
            case LAMP_URAMAKI -> new OuterWildsUramaki();
            case GIANT_MAKI -> new OuterWildsMaki();
            case BLACK_NIGIRI -> new OuterWildsNigiri();
        };

        return sushi;
    }
}
public class MyOuterWildsSushiBar {

    public static void main(String[] args) {

        SushiShop spaceSushiShop = new OuterWildsSushiShop();
        System.out.println("Вітаємо у Камельку, найкращому місці для cуші та відпочинку!" + '\n');

        Scanner in = new Scanner(System.in);
        System.out.println("В нас є: " + '\n');
        for (SushiType type : SushiType.values() ) {System.out.println(type) ;}

        System.out.println('\n' + "Що б Ви хотіли замовити???");
        String userInput = in.next();

        if (userInput.equals ("GIANT_MAKI") ) {
            spaceSushiShop.orderSushi(SushiType.GIANT_MAKI);
        }
        else if (userInput.equals ("BLACK_NIGIRI") ) {
            spaceSushiShop.orderSushi(SushiType.BLACK_NIGIRI);
        }
        else if (userInput.equals ("KAMELUK_SASHIMI") ) {
            spaceSushiShop.orderSushi(SushiType.KAMELUK_SASHIMI);
        }
        else if (userInput.equals ("LAMP_URAMAKI") ) {
            spaceSushiShop.orderSushi(SushiType.LAMP_URAMAKI);
        }
        else {System.out.println("В нас поки що нема того, що Ви хочете!");}

    }
}