package Skola.Metoder;

import java.util.Scanner;

public class Method4 {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);

        double x=kelvin(50);
        System.out.println(x);
    }

    public static double kelvin(double celsius){

        return celsius + 273.15;

    }
}
