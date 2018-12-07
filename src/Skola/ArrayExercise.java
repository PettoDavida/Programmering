package Skola;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercise {

    // 100 tal i intervallet [0-9]
    static int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};

    // 100 namn
    static String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};

    public static void main(String args[]){

        System.out.println(one());
        System.out.println(two());
        System.out.println(three());
        System.out.println(four());
        System.out.println(five());
        System.out.println(six());
        System.out.println(seven());
        System.out.println(Arrays.toString(eight()));
        System.out.println(ninth());
        System.out.println(tenth());

    }

    public static int one(){

        int counterone = 0;
        for (int i = 0; i < numbers.length; i++){

            if (numbers[i]==7){
                counterone++;
            }


        }

        return counterone;
}

    public static int two(){

        int countertwo = 0;
        for (int i = 0; i < names.length; i++){

            if (names[i]=="Tom"){
                countertwo++;
            }


        }

        return countertwo;
    }

    public static int[] three(){

        int[] list= new int[10];

        int max = 0;
        int maxnumber = 0;

        int min = 0;
        int minnumber = 0;

        for (int i = 0; i < numbers.length; i++ ){
            list[numbers[i]]++;
        }

        for (int i = 0; i < list.length; i++)
        {
            if(i == 0)
            {
                min = list[i];
                continue;
            }

            if(list[i] > max)
            {
                max = list[i];
                maxnumber = i;
            }

            if(list[i] <= min)
            {
                min = list[i - 1];
                minnumber = i;
            }

        }

        System.out.printf("Max number: %d %d ,", maxnumber, max);
        System.out.printf("Min number: %d %d ", minnumber, min);

        return new int[]{minnumber, maxnumber};
    }

    public static int four(){

        int counterfour = 0;
        for (int i = 0; i < names.length; i++){

            if (names[i]=="Drusilla"){
                break;
            }
            else{
                counterfour++;
            }


        }

        return counterfour;

    }

    public static int five(){

        int counterfive = 0;
        for (int i = 0; i < numbers.length; i++){

            if (numbers[i]%2==0){
                counterfive+=numbers[i];
            }



        }

        return counterfive;
    }

    public static int six(){

        int times = 0;
        for(int i = 0; i < names.length; i++){
            if (names[i].charAt(0) == 'L'){
                times++;
            }
        }
        return times;
    }

    public static int seven(){

        int times = 0;
        for(int i = 0; i < names.length; i++){
            if (names[i].length() == 5){
                times++;
            }
        }
        return times;

    }

    public static int[] eight(){

        int[] list= new int[10];

        for (int i = 0; i < numbers.length; i++ ){
            list[numbers[i]]++;
        }
    return list;
    }

    public static int ninth(){
        int unique = 0;
        for (int i = 0; i < names.length; i++) {

            int j;

            for (j = 0; j < names.length; j++ ){
                if(names[i].equals(names[j])){

                    break;

                }
            }

            if (i == j){
                unique++;
            }
        }
        return unique;
    }

    public static String tenth(){

        int biggestloser = 0;
        int biggestgei = 0;

        for (int i = 0; i < names.length; i++) {

            int most = 0;

            for (int j = 0; j < names.length; j++) {

                if (names[i].equals(names[j])){
                    most++;
                }

            }

            if (most > biggestloser){
                biggestloser = most;
                biggestgei = i;
            }

        }
        return names[biggestgei];
    }

}
