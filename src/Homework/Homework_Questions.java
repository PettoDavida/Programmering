package Homework;

import java.util.Scanner;

public class Homework_Questions {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        /**
         * Hur mycket väger 80 dm^3 järn?
         */

        double result = Homework_physicslibrary.volumeToMass(
                Homework_Solidtable.IRON, 80
        );

        System.out.println("Hur mycket väger 80 dm^3 järn?");
        System.out.println(result);

        /**
         * Hur långt hinner Tomas om han löper med medelhastigheten 2.8 m/s i 60 minuter?
         */

        result = Homework_physicslibrary.convertMSToKMH(2.8);

        System.out.println("Hur långt hinner Tomas om han löper med medelhastigheten 2.8 m/s i 60 minuter?");
        System.out.println(result);

        /**
         * Hur mycket energi krävs för att värma upp 5 liter vatten?
         */

        result = Homework_physicslibrary.heat(Homework_liquidtable.WATER, 5, 100);

        System.out.println("Hur mycket energi krävs för att värma upp 5 liter vatten?");
        System.out.println(result);

        /**
         * Hur stort är det totala trycket 100 meter under havsytan?
         */

        result = Homework_physicslibrary.pressureUnderWater(100);

        System.out.println("Hur stort är det totala trycket 100 meter under havsytan?");
        System.out.println(result);

        /**
         * Tomas som är 180cm lång kastar upp en boll med massan 200 gram i luften så den får starthastigheten 50 km/h. Hur högt kommer bollen?
         */

        result = Math.pow(Math.sin(90), 2)* Homework_physicslibrary.velocityToHeight(50 /3.6) +1.8;

        System.out.println("Tomas som är 180cm lång kastar upp en boll med massan 200 gram i luften så den får starthastigheten 50 km/h. Hur högt kommer bollen?");
        System.out.println(result);

        /**
         * En bil med massan 740kg accelererar med konstant acceleration från 0-100 på 4.4 sekunder. Hur stor effekt har bilens motor uppnått?
         */

        {
            double mass = 740;

            double time = 4.4;

            double velocity = Homework_physicslibrary.convertKMHToMS(100);

            double k0 = Homework_physicslibrary.kineticEnergy(mass, 0);

            double k1 = Homework_physicslibrary.kineticEnergy(mass, velocity);

            double k = Homework_physicslibrary.delta(k0, k1);

            result = Homework_physicslibrary.power(k, time);

        }

        System.out.println("En bil med massan 740kg accelererar med konstant acceleration från 0-100 på 4.4 sekunder. Hur stor effekt har bilens motor uppnått?");
        System.out.println(result);

        /**
         * En studsboll släpps från 10 meters höjd och varje gång den nuddar marken tappar den 1% av sin energi. Hur många gånger kommer bollen studsa i marken innan den inte studsar hörge än 0.5 meter?
         */

        {
            double y = 10;
            int i = 0;

            while(y > 0.5){

                y*=0.99;

                i++;
            }

            result = (double)i;
        }

        System.out.println("En studsboll släpps från 10 meters höjd och varje gång den nuddar marken tappar den 1% av sin energi. Hur många gånger kommer bollen studsa i marken innan den inte studsar hörge än 0.5 meter?");
        System.out.println(result);

        /**
         *  Jorden väger 5972000000000000000000000 kg och solen väger 1989000000000000000000000000000 kg och de är 149 600 000 km mellan de. Hur mycket påverkar de varandra?
         */

        result = Homework_physicslibrary.gravity(5.972 * Math.pow(10, 24), 1.989 * Math.pow(10, 30), 149600000);

        System.out.println("Jorden väger 5972000000000000000000000 kg och solen väger 1989000000000000000000000000000 kg och de är 149 600 000 km mellan de. Hur mycket påverkar de varandra?");
        System.out.println(result);

        /**
         * Hur mycket energi har jorden?
         */

        result = Homework_physicslibrary.emc2(5.972 * Math.pow(10, 24));

        System.out.println("Hur mycket energi har jorden?");
        System.out.println(result);

        /**
         * Hur mycket energi har valfri planet?
         */

        System.out.println("Hur mycket energi har valfri planet?");

        String planetStr = input.next();
        Homework_Planettable planet = Homework_Planettable.valueOf(planetStr.toUpperCase());

        result = Homework_physicslibrary.emc2(planet.mass);

        System.out.println(result);




    }
}
