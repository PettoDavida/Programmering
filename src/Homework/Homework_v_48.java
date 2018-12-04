package Homework;

public class Homework_v_48 {

    public static void main(String args[]){

        System.out.println(volume(11));
        System.out.println(reverse("Boi"));
        System.out.println(count("abcabcabcabcabcabcabc", 'c'));
        System.out.println(pirater("maximilian widman"));
    }

    /**
     * Beräknar volymen av ett klot
     * @param radius valfri radie
     * @return Volym av klot
     */
    public static double volume(double radius){  return (4 * Math.PI * Math.pow(radius, 3))/ 3;
    }

    /**
     * vänder på ett ord så det är baklänges
     * @param str valfritt ord
     * @return skickar tillbaka stringen reversed som är ordet omvänt
     */
    public static String reverse(String str){
        String reversed = "";
        for(int i = str.length()- 1; i >= 0; i--){
            reversed += str.charAt(i);
        }

        return reversed;
    }

    /**
     * beräknar hur många gånger valfri bokstav upprepas i ett ord
     * @param str strängen man vill ha
     * @param c bokstav metoden ska leta efter
     * @return skickar tillbaka hej som är hur många gånger c har upprepats i ordet
     */
    public static int count(String str, char c){
        int hej = 0;
        for(int i = 0; i < str.length(); i++){
           if(str.charAt(i) == c){
               hej++;
           }
        }
        return hej;
    }

    /**
     * Översätter vanlig svenska till pirat språk
     * @param str Namnet eller saken du vill ha översatt
     * @return valfritt ord i pirat språk
     */
    public static String pirater(String str){
        char konsonant[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'w', 'v', 'z', 'x' };
        String result = "";
        for(int i = 0; i < str.length(); i++) {
            boolean found = false;
            for(int j = 0; j < konsonant.length; j++) {
                if(str.charAt(i) == konsonant[j]) {
                    found = true;
                    break;
                }
            }

            if(found) {
                result += (str.charAt(i) + "o" + str.charAt(i));
            }
            else {
                result += str.charAt(i);
            }

        }

        return result;
    }


    }
