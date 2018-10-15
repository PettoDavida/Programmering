package Lööps;

import java.util.Scanner;

public class Siffersumma {

        public static void main(String args[]) {

            Scanner input =new Scanner(System.in);

            int x=0;
                x=input.nextInt();
            int resultat=0;

            while (true) {
                resultat += x % 10;
                x /= 10;


                if(x == 0) {
                    break;
                }
            }

            System.out.println(resultat);


        }

}
