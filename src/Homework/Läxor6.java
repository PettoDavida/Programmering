package Homework;

import java.util.Scanner;

public class Läxor6 {

    public static void main(String args[]){

        Scanner Patte = new Scanner(System.in);

        int base = Patte.nextInt();

        for(int i = 0; i<base; i++){
            for(int j = base - i; j>1; j--){
                System.out.print(" ");
            }

            for(int j = 0; j <= i; j++){
                System.out.print("X ");
            }

            System.out.println();
        }
    }
}


