package Skola.Metoder;

public class Method5 {

    public static void main(String args[]){

        ageControl(20);


    }
    public static int ageControl(int age)
    {
        if (age < 6)
            System.out.println("Småbarn får inte göra något.");
        if (age > 5 && age < 13)
            System.out.println("Du får spela Fortnite.");
        if (age > 12 && age < 15)
            System.out.println("Du är tonåring.");
        if (age > 14 && age < 18)
            System.out.println("Du får köra moppe.");
        if (age > 17 && age < 20)
            System.out.println("Du får köra bil.");
        if (age > 19 && age < 65)
            System.out.println("Du får gå på systemet.");
        if (age > 64 && age < 100)
            System.out.println("Du är pensionär.");
        if (age > 99)
            System.out.println("R.I.P");
        return age;
    }
}
