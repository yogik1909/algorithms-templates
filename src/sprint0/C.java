import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C {

    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        ArrayList<Double> res = new ArrayList<>(arr.size() - windowSize);
        int curSum = 0;
//        for(int i = 0; i < windowSize; i++){
//            curSum += arr.get(i);
//        }
//        res.add((double) ((double)curSum/windowSize));
        for (int i = 0; i < arr.size(); i++){
            curSum -= i >= windowSize ? arr.get(i-windowSize) : 0;
            curSum += arr.get(i);
            if (i < windowSize - 1) continue;
            res.add((double)curSum/windowSize);
        }


        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
                 int n = readInt(reader);
                 List<Integer> arr = readList(reader);
                 int windowSize = readInt(reader);
                 List<Double> result = movingAverage(n, arr, windowSize);
                 for (double elem : result) {
                     writer.write(elem + " ");
                 }
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