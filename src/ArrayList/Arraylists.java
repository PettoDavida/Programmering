package ArrayList;

import java.util.ArrayList;

public class Arraylists {
    public static void main(String[]args){

        int boi = 0;
        ArrayList<Integer> biggie = new ArrayList<>();

        for (int i = 0; i < 100; i++){

            boi= (int)(Math.random() * 11);
            biggie.add(boi);

        }// I for-loop ends

        for (int j = 0; j < biggie.size(); j++){

            System.out.println("" + j + ": "+ biggie.get(j));

        }// J for-loop ends

    }// Main ends


}// Class ends