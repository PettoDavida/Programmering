package Skola;


import java.util.Scanner;

public class GuessTheNumber {

    /**
     * DIFFICULTY_X: Denna gör så att talen man skriver in när den frågar om vilken svårighetsgrad man vill ha konverteras till en svårighetsgrad
     * YG: Talet man gissar med
     * times: hur många gånger man har gissat
     * PA: det är den som kollas när man blir frågad om man vill spela igen
     * GA: När man gissar rätt så byts den till false och den frågar om man vill spela igen och om man säger ja så blir den true igen och du får köra igen
     * AC: används bara för att en while loop ska vara igång
     * Run: Detta är variabeln som får spelet att köras och vara åging tills den blir true
     * count: räknar hur många gånger du har gissat
     * result: Talet som bestämmer parametern man ska gissa inom
     * dif: String variabeln som printas ut när den printar vad man valt som difficulty
     * guess: String variabeln som printas ut när den printar hur många försök man har
     * between: String variabeln som printas ut när den printar parametern man ska gissa inom som t.ex. 1 - 100
     * tal: scannern som tar in allt man ska skriva i konsolen
     * Input: talet man ska hitta
     * difficulty: svårighetsgraden
     */
    public static final int DIFFICULTY_EASY = 1;
    public static final int DIFFICULTY_NORMAL = 2;
    public static final int DIFFICULTY_HARD = 3;
    public static final int DIFFICULTY_SUPER_HARD = 4;
    public static final int DIFFICULTY_CUSTOM = 5;
    private static int YG = 0;
    private static int times = 0;
    private static String PA = "";
    private static boolean GA = true;
    private static boolean AC = false;
    private static boolean Run = false;
    private static int count = 0;
    private static int result = 0;
    private static String dif = "";
    private static String guess = "";
    private static String between = "";
    private static Scanner tal = new Scanner(System.in);
    private static int Input;
    private static int difficulty;

    public static void main(String[] args){




        System.out.println("Welcome to my game!");
        difficulties();
        do {
            while(!AC) {

                YG = tal.nextInt(); // tar in ett heltal
                count++; // lägger till ett på count varje gång man gissar

                if(YG == Input) { // Här kollar den om man har gissat rätt eller inte
                    System.out.println("Rätt!");
                    System.out.println("Det tog bara " + count + " försök");
                    GA = false;
                    break;
                }else if (count == times){ //Här så kollar den så att man håller sig inom försöken man får
                        System.out.println("För många försök");
                        GA = false;
                        break;
                }else if(YG > Input){ //Här tittar den om talet du gissat är större än det du ska hitta
                    System.out.println("Lower");
                }else if (YG < Input){ //Här tittar den om talet du gissat är lägre än det du ska hitta
                    System.out.println("Higher");
                }
            }
            tal.nextLine();

            do {
                System.out.println("Do you want to play again? Y/N"); // Frågar om man vill spela igen
                PA = tal.nextLine(); // Tar in svaret
                if (PA.toLowerCase().equals("y")) { // kollar om det är y som betyder yes
                    System.out.println("You chose to play again!");
                    count = 0;
                    difficulties();
                    GA = true;

                } else if (PA.toLowerCase().equals("n")) {// kollar om det är n som betyder no
                    System.out.println("Goodbye");
                    Run = true;
                    break;
                } else{ // här fortsätter loopen om man skriver in något som inte är y eller n

                }
            }while(!GA);
        }while(!Run);

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
                System.out.println("Choose your parameter for between 1-x. x being your number");
                result = tal.nextInt();
                System.out.println("Choose how many times you can guess");
                times = tal.nextInt();
            }
        }
        Input = (int) (Math.random() * result) + 1;
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

