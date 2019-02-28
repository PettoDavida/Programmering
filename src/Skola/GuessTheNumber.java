package Skola;


import java.util.Scanner;

public class GuessTheNumber {

    private static int[][] difficulty = {
        {0, 1, 100, -1}, //Lätt
        {1, 1, 500, -1}, // Mellan
        {2, 1, 400, 10}, // Svår
        {3, 1, 1000, 1}, // Omöjlig
        {4, 0, 0, 0} // Custom
    };

    public static void main(String[] args){

        Scanner tal = new Scanner(System.in);

        System.out.println();
        int bogdan = 0;
        int dobondi = (int) (Math.random() * 10 ) + 1;
        String bogdish = "";
        boolean nog = false;
        boolean nig = false;
        int count = 0;


        do {
            while(!nog){
                bogdan = tal.nextInt();
                count++;
                if(bogdan == dobondi){
                    System.out.println("Rätt!");
                    System.out.println("Det tog bara " + count + "försök");
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
