package Skola;


import java.util.Scanner;

public class GuessTheNumber {

    public static final int DIFFICULTY_EASY = 1;
    public static final int DIFFICULTY_NORMAL = 2;
    public static final int DIFFICULTY_HARD = 3;
    public static final int DIFFICULTY_SUPER_HARD = 4;
    public static final int DIFFICULTY_CUSTOM = 5;
    private static int bogdan = 0;
    private static int guesses = 0;
    private static int times = 0;
    private static String bogdish = "";
    private static boolean bignig = false;
    private static boolean nog = false;
    private static boolean nig = false;
    private static int count = 0;
    private static int result = 0;
    private static String dif = "";
    private static String guess = "";
    private static String between = "";
    private static Scanner tal = new Scanner(System.in);
    private static int dobondi;
    private static int difficulty;

    public static void main(String[] args){




        System.out.println("Welcome to my game!");
        difficulties();
        do {
            while(!nog) {

                bogdan = tal.nextInt(); // tar in ett heltal
                count++; // lägger till ett på count varje gång man gissar

                if(bogdan == dobondi) { // Här kollar den om man har gissat rätt eller inte
                    System.out.println("Rätt!");
                    System.out.println("Det tog bara " + count + " försök");
                    bignig = false;
                    break;
                }else if (count == guesses){ //Här så kollar den så att man håller sig inom försöken man får
                        System.out.println("För många försök");
                        bignig = false;
                        break;
                }else if(bogdan > dobondi){ //Här tittar den om talet du gissat är större än det du ska hitta
                    System.out.println("Lower");
                }else if (bogdan < dobondi){ //Här tittar den om talet du gissat är lägre än det du ska hitta
                    System.out.println("Higher");
                }
            }
            tal.nextLine();

            do {
                System.out.println("Do you want to play again? Y/N"); // Frågar om man vill spela igen
                bogdish = tal.nextLine(); // Tar in svaret
                if (bogdish.toLowerCase().equals("y")) { // kollar om det är y som betyder yes
                    count = 0;
                    nog = false;
                    difficulties();
                    bignig = true;

                } else if (bogdish.toLowerCase().equals("n")) {// kollar om det är n som betyder no
                    System.out.println("Goodbye");
                    nig = true;
                    nog = true;
                    break;
                } else{ // här fortsätter loopen om man skriver in något som inte är y eller n

                }
            }while(!bignig);
        }while(!nig);

    }

    public static void difficulties(){
        System.out.println("Choose what difficulty you want or make your own!");
        System.out.println(" 1 = EASY");
        System.out.println(" 2 = NORMAL");
        System.out.println(" 3 = HARD");
        System.out.println(" 4 = SUPER_HARD");
        System.out.println(" 5 = CUSTOM");
        difficulty = tal.nextInt();
        switch (difficulty) {
            case DIFFICULTY_EASY: {
                result = 100;
                times = -1;
            }
            break;

            case DIFFICULTY_NORMAL: {
                result = 300;
                times = 30;
            }
            break;

            case DIFFICULTY_HARD: {
                result = 666;
                times = 10;
            }
            break;

            case DIFFICULTY_SUPER_HARD: {
                result = 1000;
                times = 1;
            }
            break;

            case DIFFICULTY_CUSTOM: {
                result = tal.nextInt();
                times = tal.nextInt();
            }
        }
        dobondi = (int) (Math.random() * result) + 1;
        guesses = times;
        if (difficulty == 1){
            dif = "Easy";
            guess = "Unlimited";
            between = "1 - " + result;
        }else if (difficulty == 2){
            dif = "Normal";
            guess = "30";
            between = "1 - " + result;
        }else if (difficulty == 3){
            dif = "Hard";
            guess = "10";
            between = "1 - " + result;
        }else if (difficulty == 4){
            dif = "Super-Hard";
            guess = "1";
            between = "1 - " + result;
        }else if (difficulty == 5){
            dif = "Custom ";
            guess = "" + times;
            between = "1 - " + result;

        }
        System.out.println("You chose " + dif + " as your difficulty.");
        System.out.println("You have " + guess + " guesses");
        System.out.println("The number is between " + between);
        System.out.println("Start Guessing!");
    }

}

