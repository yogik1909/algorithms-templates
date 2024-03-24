package sprint1_nonfinals;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class F {

    private static boolean isPalindrome(String text) {
        String newText = text.replaceAll("[\\W,_]", "");
        for (int i = 0, j = newText.length()-1  ; j >= 0; i++, j--){
            if (Character.toLowerCase(newText.charAt(i)) != Character.toLowerCase(newText.charAt(j))){
                return false;
            }
        }


        return true;
    }
    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            if (isPalindrome(text)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
