package Skola.Lööps;

import java.util.Scanner;

public class Minsta_tal {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        double x=0;
            x=input.nextDouble();

        double y=0;
            y=input.nextDouble();

        if (x > y) {
            System.out.println(y);
        }
        if (y > x) {
            System.out.println(x);
        }


    }

}
