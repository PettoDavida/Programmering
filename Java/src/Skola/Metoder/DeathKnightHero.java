package Skola.Metoder;

import java.util.Scanner;

public class DeathKnightHero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int battles = sc.nextInt();
        int won = 0;
        sc.nextLine();
        while (battles-- > 0) {
            String abilities = sc.nextLine();
            if (!abilities.toLowerCase().contains("cd"))
                won++;
        }
        System.out.println(won);
        sc.close();
    }
}