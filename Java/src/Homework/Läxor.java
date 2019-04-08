package Homework;

import java.util.Scanner;

public class Läxor {

    public static void main(String args[]) {

        System.out.println("Skriv in olika nummer så kommer jag addera alla. Du får summan när du skriver 0.");
        Scanner input= new Scanner(System.in);
        boolean inprogress = true;
        double tal;
        double summa = 0;

        while(inprogress){

            tal = input.nextInt();
            if(tal == 0){
                inprogress = false;
            }
            else {
                summa += tal;
            }
        }
        System.out.println(summa);
    }
}