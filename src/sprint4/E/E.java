package sprint4.E;

import java.util.HashMap;
import java.util.Stack;

public class E {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static HashMap<Integer, String> mapIndex = new HashMap<>();
    public static void main(String[] args) throws Exception {
        int maxLength = 1000; // Максимальная длина строки для демонстрации
        for (int length = 1; length <= maxLength; length++) {
            generateAllStrings("", length);
        }


    }

    public static void generateAllStrings(String currentString, int maxLength) throws Exception {
        if (currentString.length() == maxLength) {
            int has = Polynomial(currentString, 1000,123987123);
            if (mapIndex.containsKey(has)){
                System.out.println(currentString);
                System.out.println(mapIndex.get(has));
                throw new Exception("Done!");
            }
            mapIndex.put(has, currentString);
            return;
        }

        for (int i = 0; i < ALPHABET.length(); i++) {
            generateAllStrings(currentString + ALPHABET.charAt(i), maxLength);
        }
    }

    public static int Polynomial(String hasingString, int x, int mod) {
        long res = 0;

        for (int i = 0; i < hasingString.length(); i++){
            res = (res * x + hasingString.charAt(i)) % mod;
        }
        return (int) res;
    }
}
