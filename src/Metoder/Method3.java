package Metoder;

import java.util.Scanner;

public class Method3 {

    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        count(x);
    }

    public static void count(int n){

        for(int i=0;i<=n;i++){
            System.out.println(i);
        }

    }

}
