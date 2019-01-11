package Skola;

public class Bubblesort {

    public static void main(String args[]) {

    }

        /**
         * Sorts the list with the Bubble Sort algorithm
         * @param list The list to be sorted NOTE: passed as a reference
         */

        public static void bubbleSort ( int[] list){
            boolean stop = false; // Skapar en boolean som är false vid namnet stop
            while (!stop) { // säger att så länge som stop är false så ska den loopa
                int switches = 0; // Skapar en int som ska användas för att kolla om loopen switchar plats på värden eller inte. Den blir resettad vid varje loop
                for (int i = 0; i < list.length - 1; i++) { // en for-loop som ska gå igenom hela listan
                    if (list[i] > list[i + 1]) { // en if sats som säger att om indexen innan är större så ska den switcha
                        int temp = list[i]; //skapar en temporär int för den första indexen av de två indexen
                        list[i] = list[i + 1]; // här sätter den den första indexen på platsen av den andra
                        list[i + 1] = temp; // här sätter den den andra indexen på platsen av den första

                        switches++; // här lägger den till 1 på switches inten
                    }
                }

                if (switches == 0) // här så kollar den om switches ändrades eller inte och om den inte ändras så stoppar den loopen
                    stop = true;
            }
        }
}