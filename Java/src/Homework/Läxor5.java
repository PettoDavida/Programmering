package Homework;

import java.util.Scanner;

public class Läxor5 {

    public static void main(String args[]){

        Scanner input=new Scanner(System.in);


        stairs(4);
    }
    public static int stairs(int steps){
        char x = 'x';
        for (int i = 0; i < steps; i++ ){
            for (int y = 0; y <= i; y++) {
                System.out.print(x);
            }
            System.out.println();
        }
        return steps;
    }
}

