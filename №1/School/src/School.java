import java.util.Scanner;
class OurSchool {

    private int StudentsCount;
    private int NumberOfSchool;

    public void SetNumberOfSchool(int numberOfSchool) {this.NumberOfSchool = numberOfSchool;}
    public void SetStudentsCount (int studentsCount) {this.StudentsCount = studentsCount;}
    public int GetNumberOfSchool() {return NumberOfSchool;}
    public int GetStudentsCount() {return StudentsCount;}

    enum SeasonOfYear {

        Winter("Зима, вчитися не треба."),
        Spring("Весна, вчимося."),
        Summer("Літо, вчитися не треба."),
        Autumn("Осінь, вчимося.");
        private String season;
        SeasonOfYear(String season) {this.season = season;}
        public String currentSeason() {return season;}
    }

    public void PrintTheResults() {

        System.out.println("Номер школи: " + GetNumberOfSchool() + ", у ній " + GetStudentsCount() + " студентів" + '\n');

        System.out.println(SeasonOfYear.Winter.currentSeason());
        System.out.println(SeasonOfYear.Summer.currentSeason());
        System.out.println(SeasonOfYear.Spring.currentSeason());
        System.out.println(SeasonOfYear.Autumn.currentSeason());

    }
}

public class School {
    public static void main(String [] args) {

        OurSchool mySchool = new OurSchool();
        Scanner in = new Scanner(System.in);

        System.out.println("Введіть кількість студентів: ");
        mySchool.SetStudentsCount(in.nextInt() );

        System.out.println("Введіть номер школи: ");
        mySchool.SetNumberOfSchool(in.nextInt() );

        System.out.println("Результати: \n");
        mySchool.PrintTheResults();
    }
}