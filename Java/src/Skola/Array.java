package Skola;

import java.util.Scanner;

public class Array {

    public static void main(String args[]) throws InterruptedException {
        int[] arr = new int[10];
        arr[0] = 123;
        arr[1] = 321;
        arr[2] = 7;
        arr[3] = 19;
        arr[4] = 42;
        arr[5] = 69;
        arr[6] = 144;
        arr[7] = 6;
        arr[8] = 27;
        arr[9] = 10038;

        Scanner gei = new Scanner(System.in);

        System.out.println("Skriv in tal mellan 0-9");
        int input = gei.nextInt();
        System.out.println("Detta är ditt tal:" + " " + arr[input]);
        System.out.println(" ");
        Thread.sleep(1000);

        for(int i=0; i < arr.length; i++){
            System.out.print(" " + arr[i]);
            Thread.sleep(500);
        }
        System.out.println(" ");
        for(int i=arr.length - 1; i >= 0; i--){
            System.out.print(" " + arr[i]);
            Thread.sleep(500);
        }







    }
}
