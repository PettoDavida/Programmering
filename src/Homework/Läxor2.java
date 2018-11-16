package Homework;

import java.util.Scanner;

public class Läxor2 {

    public static void main(String args[]){
        Scanner Patte = new Scanner(System.in);
        boolean bigman= true;

        while(bigman){
            String text =Patte.next();

            if(text.equals("exit")){
                bigman = false;
            }

        }
    }
}
