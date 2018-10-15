package Metoder;

import java.util.Scanner;

public class Method2 {

    public static void main(String args[]){

        Scanner input=new Scanner(System.in);

        int x=input.nextInt();
        int y=input.nextInt();

        int z=min(x,y);

        System.out.println("Result: " + z);

    }
    public static int min(int a, int b){

        if (a>b){
            return b;
        }
        else {
            return a;
        }
    }
}
