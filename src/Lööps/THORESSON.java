package Lööps;

import java.util.Scanner;

public class THORESSON {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        int resultat = 1;

        int counter = 0;

        while(true){

            int x = input.nextInt();

            counter++;

            if(counter == 10){

                break;

            }

            resultat *= x;

            if (resultat > 100000){

                break;

            }


        }

        System.out.println("Resultat:" + resultat + " " + "Count:" + counter);

    }
}
