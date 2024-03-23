package sprint1_nonfinals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class E {
    static class  StrSizeLine implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.length() < b.length() ? -1 : a.length() == b.length() ? 0 : 1;
        }
    }
    private static String getLongestWord(String text) {
        String[] arrstr = text.split(" ");
        List<String> listLine = Arrays.asList(arrstr)
                .stream()
                .map(elem -> new String(String.valueOf(elem)))
                .collect(Collectors.toList());
        Collections.sort(listLine, new StrSizeLine() );
        int maxLe = listLine.get(listLine.size() - 1).length();
        for (String srt : arrstr){
            if (srt.length() == maxLe) return srt;
        }

        return "";


    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int textLength = readInt(reader);
            String text = reader.readLine();
            String longestWord = getLongestWord(text);
            System.out.println(longestWord);
            System.out.println(longestWord.length());
        }

    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
