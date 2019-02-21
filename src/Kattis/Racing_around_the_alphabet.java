package Kattis;


import java.util.Scanner;

public class Racing_around_the_alphabet {

    public static void main(String[] args){

        Scanner tal = new Scanner(System.in);

        System.out.println();
        int bogdan = 0;
        int dobondi = (int) (Math.random() * 10 ) + 1;
        String bogdish = "";
        boolean nog = false;
        boolean nig = false;



        do {
            while(!nog){
                bogdan = tal.nextInt();
                if(bogdan == dobondi){
                    System.out.println("Rätt");
                    break;
                }else if(bogdan > dobondi){
                    System.out.println("Lägre"); //Här printar den lägre om talet man gissat är större än talet man ska hitta
                }else if (bogdan < dobondi){
                    System.out.println("Högre"); //Här printar den högre om talet man gissat är lägre än talet man ska hitta
                }
            }

            System.out.println("Vill du köra igen? Svara med ja eller nej.");
            bogdish = tal.nextLine();
            if (bogdish == "ja"){
                nog = false;
            }else if (bogdish == "nej"){
                nig = true;
            }
        }while(!nig);

    }

}
