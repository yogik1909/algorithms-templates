import java.util.*;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    // Если ответ существует, верните список из двух элементов
    // Если нет - то верните пустой список 
    private static List<Integer> twoSum(List<Integer> arr, int targetSum) {
        Collections.sort(arr);
        int curSum;
        int le = 0, ri = arr.size() - 1;
        while (le < ri){
            curSum = arr.get(le) + arr.get(ri);
            if (curSum == targetSum) return new ArrayList<>(List.of(new Integer[]{arr.get(le), arr.get(ri)}));
            if (curSum < targetSum)
                le++;
            else ri--;
        }
        return new ArrayList<Integer>();

    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int targetSum = readInt(reader);
            List<Integer> result = twoSum(arr, targetSum);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                System.out.println(result.get(0) + " " + result.get(1));
            }
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return  Arrays.asList(reader.readLine().split(" "))
                        .stream()
                        .map(elem -> Integer.parseInt(elem))
                        .collect(Collectors.toList());
    }
    
}