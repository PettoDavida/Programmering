package Skola.Metoder;

public class Method6 {

    public static void main(String args[]){

        stairs(10);
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
