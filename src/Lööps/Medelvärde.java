package Lööps;

import java.util.Scanner;

public class Medelvärde {

    public static void main(String args[]) {

        Scanner input =new Scanner(System.in);

        int resultat=0;
        int counter=0;

        while (true) {
            int x = input.nextInt();
            if(x == 0) {
                break;
            }

            resultat += x;
            counter++;
        }

        int medel = resultat / counter;

        System.out.println("Resultat: " + resultat + " Medel: " + medel);


    }

}
