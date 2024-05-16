package sprint4.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B {
    public static void main(String[] args) throws IOException {
        String[] res;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            res = reader.readLine().split(" ");

        }
        int[] prefSum = new int[res.length + 1];
        for (int i = 1; i <= res.length; i++) {
            prefSum[i] = prefSum[i - 1] + (res[i - 1].equals("0")? -1 : 1);
        }
        int maxLength = 0;
        int startIndex = -1;

        HashMap<Integer, Integer> mapIndex = new HashMap<>();
        for (int i = 0; i < prefSum.length; i++) {
            if (mapIndex.containsKey(prefSum[i])) {
                int curLength = i - mapIndex.get(prefSum[i]);
                if (curLength > maxLength) {
                    maxLength = curLength;
                    startIndex = mapIndex.get(prefSum[i]) + 1;
                }
            }else {
                mapIndex.put(prefSum[i], i);
            }
        }

        System.out.println(maxLength);

    }
}
