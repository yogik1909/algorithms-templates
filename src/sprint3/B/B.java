package sprint3.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static String[] afl = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
           String n =  reader.readLine();
           StringBuilder sb = new StringBuilder("");
            createSequence(n, "", 0, sb);
            System.out.print(sb);
        }

    }

    static void createSequence(String n, String curPref, int curInd, StringBuilder ret){
        if (n.length() == curPref.length()){
            ret.append(curPref).append(" ");
            return ;
        }

        char curPres = n.charAt(curInd);
        int indexAlf = Integer.parseInt(String.valueOf(curPres)) - 2;
        String curGroup = afl[indexAlf];
        for (char curChar : curGroup.toCharArray()){
            StringBuilder sb = new StringBuilder(curPref);
            sb.append(curChar);
            createSequence(n, sb.toString(), curInd + 1, ret);
        }

    }

}
