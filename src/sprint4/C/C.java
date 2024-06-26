package sprint4.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class C {
    public static void main(String[] args) throws IOException {
        String s, t, neg = "NO", post = "YES";
        HashMap<Character, Character> mapS_T = new HashMap<>();
        HashMap<Character, Character> mapT_S = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            s = reader.readLine();
            t = reader.readLine();
        }

        if (s.length() != t.length()) {
            System.out.println(neg);
            return;
        }
        int i = 0;
        for (; i < s.length() && i < t.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (mapS_T.containsKey(charS)){
                if (mapS_T.get(charS) != charT){
                    System.out.println(neg);
                    return;
                }
            }else {
                if (mapT_S.containsKey(charT)){
                    System.out.println(neg);
                    return;
                }
                mapS_T.put(charS, charT);
                mapT_S.put(charT, charS);
            }
        }
        System.out.println(post);
    }
}
