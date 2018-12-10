package Skola;


import java.util.Arrays;

public class ArrayExercise {

    // 100 tal i intervallet [0-9]
    static int[] numbers = {1,1,1,2,6,7,8,4,3,7,8,9,3,1,3,7,8,5,3,4,8,9,6,4,2,4,7,9,7,4,3,2,3,6,7,8,7,7,5,7,9,6,1,4,0,8,6,5,6,8,9,0,7,5,4,3,2,4,5,9,8,5,9,8,8,4,5,6,7,8,9,0,9,0,9,7,5,2,1,2,3,4,5,4,4,5,3,4,5,0,8,7,0,7,9,7,0,6,5,4};

    // 100 namn
    static String[] names = {"Crystal","Tam","Ed","Beulah","Daina","Benjamin","Kia","Clelia","Cassy","Gita","Celsa","Karoline","Talitha","Lewis","Betsy","Colin","Glendora","Carola","Rosalba","Jeanie","Yevette","Armand","Neal","Lilla","Dorethea","Delta","Maye","Nikita","Shoshana","Carola","Margie","Haywood","Venessa","Natacha","Gilbert","Kandi","Tyisha","Tammie","Blossom","Penney","Diana","Audrey","Willard","Zoraida","Drusilla","Jacquline","Cyndy","Janiece","Tressie","Kami","Lashanda","Leann","Tom","Santana","Junita","Gisela","Tom","Marquerite","Bryant","Lauralee","Yael","Kelle","Samantha","Tom","Meta","Lanette","Wanetta","Carola","Jana","Neal","Brady","Rigoberto","Felicia","Hellen","Georgeann","Carola","Isaias","Ellis","Roseanne","Lenard","Ela","Ophelia","Alesha","Mafalda","Flor","Kelsi","Autumn","Sondra","Pasty","Jacquelyne","Benjamin","Emmie","Mickie","Lang","Jamee","Felice","Daniella","Carola","Nathalie","Genevive"};

    public static void main(String args[]){

        System.out.println(one());
        System.out.println(two());
        int[] result = three();

        int minNumber = result[0];
        int minFreq = result[1];

        int maxNumber = result[2];
        int maxFreq = result[3];

        System.out.printf("\t Minst: %d:or med %dst och flest: %d:or med %dst\n", minNumber, minFreq, maxNumber, maxFreq);

        System.out.println(four());
        System.out.println(five());
        System.out.println(six());
        System.out.println(seven());
        System.out.println(Arrays.toString(eight()));
        System.out.println(ninth());
        System.out.println(tenth());

    }

    /**
     * Hur många 7:or finns det i numbers?
     * @return Antal 7:or som finns
     */
    public static int one(){

        int counterone = 0; //counter för hur många 7:or som finns
        for (int i = 0; i < numbers.length; i++){ // går genom varje nummer i numbers

            if (numbers[i]==7){
                counterone++; // lägger till 1 på countern för varje 7:a den hittar
            }


        }

        return counterone; // hur många 7:or som finns
}

    /**
     * Hur många personer som heter Tom finns det i names?
     * @return personer som heter Tom i names
     */
    public static int two(){

        int countertwo = 0; // counter för hur många Tom som finns
        for (int i = 0; i < names.length; i++){ // går genom varje namn i names

            if (names[i]=="Tom"){ // adderar 1 för varje gång Tom dyker upp
                countertwo++;
            }


        }

        return countertwo; // hur många Tom som finns i names
    }

    /**
     * Vilket nummer finns det flest respektive minst utav i numbers?
     * @return De nummer som kommer upp flest gånger och minst gånger
     */
    public static int[] three(){

            int[] List = Frequent();

            int[] Index = new int[10];
            for (int i = 0; i < Index.length; i++) {
                Index[i] = i;
            }
            // Detta är en algorithm som tar t.ex. om vi har 5 3 9 2 0 så börjar den med 5 och 3 och kollar vilken som är
            // minst och flytter den till vänster så att de minsta alltid är längst till vänster tills det inte går mer
            // och då ska det se ut som så här 0 2 3 5 9
            boolean stop = false;
            while(!stop) {
                int switches = 0;

                for (int i = 0; i < List.length; i++) {
                    if (i < List.length - 1) {
                        int first = List[i];
                        int second = List[i + 1];

                        if (first > second) {
                            List[i] = second;
                            List[i + 1] = first;

                            int temp = Index[i];
                            Index[i] = Index[i + 1];
                            Index[i + 1] = temp;

                            switches++;
                        }
                    }
                }

                if(switches == 0)
                    stop = true;
            }

            int minFreq = List[0];
            int minNumber = Index[0];

            int maxFreq = List[List.length - 1];
            int maxNumber = Index[Index.length - 1];

            return new int[] { minNumber, minFreq, maxNumber, maxFreq };
        }

    /**
     * På vilket index finns namnet Drusilla i names?
     * @return nummret Drusilla kommer upp i names arrayen
     */
    public static int four(){

        int counterfour = 0;
        for (int i = 0; i < names.length; i++){ //Går genom hela names arrayen

            if (names[i]=="Drusilla"){ // letar efter namnet Drusilla i arrayen och bryter loopem om den hittar Drusilla annars fortsätter den
                break;
            }
            else{
                counterfour++;
            }


        }

        return counterfour; // platsen namnet Drusilla ligger på

    }

    /**
     * Vad är summan av alla jämna tal i numbers?
     * @return Summa av alla jämna tal
     */
    public static int five(){

        int counterfive = 0;
        for (int i = 0; i < numbers.length; i++){ // går genom hela numbers arrayen

            if (numbers[i]%2==0){
                counterfive+=numbers[i]; // adderar ihop numrerna som kan delas på två. Detta är för att de är jämna
            }



        }

        return counterfive; // totala summan av alla jämna tal
    }

    /**
     * Hur många namn börjar på bokstaven L i names?
     * @return hur många namn som börjar på L
     */
    public static int six(){

        int times = 0;
        for(int i = 0; i < names.length; i++){ // går genom hela names arrayen
            if (names[i].charAt(0) == 'L'){ // lägger till 1 på times varje gång ett namn börjar på L
                times++;
            }
        }
        return times;
    }

    /**
     * Hur många namn är fem bokstäver långa i names?
     * @return Hur många namn som har 5 bokstäver
     */
    public static int seven(){

        int times = 0;
        for(int i = 0; i < names.length; i++){ //går genom arrayen names
             if (names[i].length() == 5){ // varje gång ett namn har 5 bokstäver i längd tå adderar den 1 till times
                times++;
            }
        }
        return times;

    }

    /**
     * Hur många finns det av varje tal i numbers?
     * (antal 1:or, antal 2:or ...)
     * @return hur många som finns av respektive nummer mella 0-9
     */
    public static int[] eight(){

        int[] list= new int[10];

        for (int i = 0; i < numbers.length; i++ ){ //går genom arrayen numbers och lägger till de olika nummrerna på sin plats i list arrayen
            list[numbers[i]]++;
        }
    return list;
    }

    /**
     * Hur många unika namn finns det i names?
     * @return hur många olika namn som finns
     */
    public static int ninth(){
        int unique = 0;
        for (int i = 0; i < names.length; i++) { // går genom varje namn i arrayen names

            int j;

            for (j = 0; j < names.length; j++ ){ // kollar namnet och adderar 1 till unique om namnet inte har uppstått innan sen bryter den loopen när den har gått genom alla namn
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

    /**
     * Vilket är det namn som förekommer flest gånger i names?
     * @return namnet som uppstår mest gånger
     */
    public static String tenth(){

        int biggestloser = 0;
        int biggestgei = 0;

        for (int i = 0; i < names.length; i++) { // går genom hela arrayen names

            int most = 0;

            for (int j = 0; j < names.length; j++) { // går genom arrayen igen och om den hittar ett namn igen så adderas det på most

                if (names[i].equals(names[j])){
                    most++;
                }

            }

            if (most > biggestloser){
                biggestloser = most; // om most är större än biggestloser så ska biggestloser bli most
                biggestgei = i; // namnet som ligger på nummret i är det som kommer upp mest och skickas tillbaka
            }

        }
        return names[biggestgei];
    }

    /**
     * Beräknar hur många gånger nummer uppstår
     * @return antal nummer för de olika nummrena
     */
    private static int[] Frequent() {
        int[] result = new int[10];

        for (int i = 0; i < numbers.length; i++){
            result[numbers[i]]++;
        }

        return result;
    }

}
