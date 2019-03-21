package Kattis;

import java.util.ArrayList;
import java.util.Scanner;

public class SecureDoors {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<String> list = new ArrayList<>();

        while (n-- > 0)
        {
            String[] line = scanner.nextLine().split(" "); // Splitar en string som t.ex. Entry Gabriel och sen så sätter den in de i en array

            String command = line[0]; // I arrayen sätts då Entry i index 0
            String name = line[1]; // I arrayen sätts då Gabriel i index 1

            if(command.equals("entry")) // här kollar den om första index altså 0 är entry eller om den är exit som kommer under i else if satsen
            {
                boolean found = false;
                for(int i = 0; i < list.size(); i++) { // Går genom arrayen och kolla om personen har enterat två gånger.
                    if(list.get(i).equals(name)) {
                        found = true;
                        System.out.printf("%s entered (ANOMALY)\n", name);

                        break;
                    }
                }

                if(!found) { // om den inte hittar att de eneterat innan så sätter den in namnet
                    list.add(name);
                    System.out.printf("%s entered\n", name);
                }
            } else if(command.equals("exit")) { // kollar om de har enterat och tar bort de
                boolean found = false;
                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i).equals(name)) {
                        found = true;
                        list.remove(i);
                        System.out.printf("%s exited\n", name);
                        break;
                    }
                }

                if(!found) { // om de inte hittar att namnet har enterat så säger den att det är en anomaly
                    System.out.printf("%s exited (ANOMALY)\n", name);
                }
            }
        }
    }

}
