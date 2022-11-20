import java.util.Scanner;
abstract class Coffee {
    public void makeCoffee() {}
    public void pourIntoCup() {}
    public void AddSomethingSpecil() {}
}

enum CoffeeType {
    BLACK_LATTE,
    GIANT_CAPPUCCINO,
    LAMP_ESPRESSO,
    KAMELUK_AMERICANO
}

class OuterWildsCaffeLatte extends Coffee {
    @Override
    public void AddSomethingSpecil() {
        System.out.println ("Додамо до нашого лате коріння з Чорного Терновику..");
    }
}

class OuterWildsCappuccino extends Coffee {
    @Override
    public void AddSomethingSpecil() {
        System.out.println ("Додамо до нашого капучіно води з Пучини Гіганту..");
    }
}

class OuterWildsEspresso extends Coffee {
    @Override
    public void AddSomethingSpecil() {
        System.out.println ("Додамо до нашого експресо шоколаду з Пустотної Лампи...");
    }
}

class OuterWildsAmericano extends Coffee {
    @Override
    public void AddSomethingSpecil() {
        System.out.println ("Прекрасний кофе з маршмелоу з Камельку..");
    }
}

abstract class CoffeeShop {
    public Coffee orderCoffee (CoffeeType type) {

        Coffee coffee = createCoffee (type);
        coffee.makeCoffee();
        coffee.pourIntoCup();

        coffee.AddSomethingSpecil();
        System.out.println ('\n' + "Насолоджуйтеся!");
        return coffee;
    }
    protected abstract Coffee createCoffee (CoffeeType type);
}

class OuterWildsCoffeeShop extends CoffeeShop {
    @Override
    public Coffee createCoffee (CoffeeType type) {
        Coffee coffee = switch (type) {
            case KAMELUK_AMERICANO -> new OuterWildsAmericano();
            case LAMP_ESPRESSO -> new OuterWildsEspresso();
            case GIANT_CAPPUCCINO -> new OuterWildsCappuccino();
            case BLACK_LATTE -> new OuterWildsCaffeLatte();
        };

        return coffee;
    }
}
public class MyOuterWildsCoffeeShop {

    public static void main(String[] args) {

        CoffeeShop spaceCoffeeShop = new OuterWildsCoffeeShop();
        System.out.println("Вітаємо у Камельку, найкращому місці для кофе та маршмелоу!" + '\n');

        Scanner in = new Scanner(System.in);
        System.out.println("В нас є: " + '\n');
        for (CoffeeType type : CoffeeType.values() ) {System.out.println(type) ;}

        System.out.println('\n' + "Що б Ви хотіли замовити???");
        String userInput = in.next();

if (userInput.equals ("GIANT_CAPPUCCINO") ) {
    spaceCoffeeShop.orderCoffee(CoffeeType.GIANT_CAPPUCCINO);
}
else if (userInput.equals ("BLACK_LATTE") ) {
    spaceCoffeeShop.orderCoffee(CoffeeType.BLACK_LATTE);
}
else if (userInput.equals ("KAMELUK_AMERICANO") ) {
    spaceCoffeeShop.orderCoffee(CoffeeType.KAMELUK_AMERICANO);
}
else if (userInput.equals ("LAMP_ESPRESSO") ) {
    spaceCoffeeShop.orderCoffee(CoffeeType.LAMP_ESPRESSO);
}
else {System.out.println("В нас поки що нема того, що Ви хочете!");}

    }
}