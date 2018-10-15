package Homework;

public class Homework_v_41 {

    public static void main(String args[]){

        System.out.println(volume(11));
        System.out.println(reverse("Boi"));
        System.out.println(count("bock", 'c'));
        System.out.println(pirater("maximilian"));
    }
    public static double volume(double radius){  return (4 * Math.PI * Math.pow(radius, 3))/ 3;
    }
    public static String reverse(String str){
        String reversed = "";
        for(int i = str.length()- 1; i >= 0; i--){
            reversed += str.charAt(i);
        }

        return reversed;
    }
    public static int count(String str, char c){
        int hej = 0;
        for(int i = 0; i < str.length(); i++){
           if(str.charAt(i) == c){
               hej++;
           }
        }
        return hej;
    }
    public static String pirater(String str){
        char konsonant[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'z', 'x' };
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
