package Homework;

import java.util.Scanner;

public class Läxor3 {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        int counter = 0;
        int resultat = 1;

        while (true) {
            int x = input.nextInt();
            counter++;
            if (counter == 10) {
                break;
            }
            resultat *= x;
            if (resultat > 100000){
                break;
            }

        }

        System.out.println(resultat + " " + counter);


    }

}