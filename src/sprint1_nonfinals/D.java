package sprint1_nonfinals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.io.IOException;


public class D {

    private static int getWeatherRandomness(List<Integer> temperatures) {
        int sum = 0;
        Integer cur = null, prv = null, nxt = null;
        int size = temperatures.size();
        for(int i = 0; i < size; i++){
            cur = temperatures.get(i);
            prv = temperatures.get(i > 0? i-1: 0);
            nxt  = temperatures.get(i+1 < size? i+1: i);
            if ((i == 0 || cur.intValue() > prv.intValue()) && (i == size-1 || cur.intValue() > nxt.intValue())) sum++;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfDays = readInt(reader);
            List<Integer> temperatures = readList(reader);
            int chaosNumber = getWeatherRandomness(temperatures);
            System.out.println(chaosNumber);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }
}
