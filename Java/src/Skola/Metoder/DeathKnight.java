package Skola.Metoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DeathKnight {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of matched ");
        int Battles = input.nextInt();
        int won = 0;
        String chars = "cdo";
        Random rnd = new Random();

        List<String> matches = new ArrayList<String>();
        String abilities = "";
        // Create n battles
        for (int i = 0; i < Battles; i++) {
            int noOfActions = rnd.nextInt(1000);
            for (int j = 0; j < noOfActions; j++) {
                char c = chars.charAt(rnd.nextInt(chars.length()));
                abilities += c;
            }
            matches.add(abilities);
        }
        for (String match : matches) {
            if (!match.toLowerCase().contains("cd")) {
                System.out.println("Match Won :-) : " + match);
                won++;
            } else {
                System.out.println("Match not won: " + match);
            }
       }
        // Check how many wins
        System.out.println("No of matches won = " + won);
    }
}
