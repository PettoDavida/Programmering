package Lööps;

import java.util.Scanner;

public class Delbart_med_7 {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        int tal = 0;
        int resultat = 0;

        while (tal <= 10000) {
            if(tal % 7 == 0)
                resultat += tal;
            tal++;
        }

        System.out.println(resultat);
    }

}
