package sprint1_nonfinals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K {

    private static List<Integer> getSum(List<Integer> numberList, int k) {
        List <Integer> newList = String.valueOf(k).chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> resList= new ArrayList<>();
        boolean over = false;

        for (int i = numberList.size()-1, j = newList.size() - 1; i >= 0 || j >=0; i--, j-- ){
            int oper1 = i >= 0 ? numberList.get(i) : 0;
            int ope2 = j >= 0?newList.get(j) : 0;
            int res = oper1+ope2+(over?1:0);
            if (res >= 10){ over = true; res -= 10;}
            else over = false;
            resList.add(0, res);
        }
        if (over) resList.add(0, 1);
        return resList;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberLength = readInt(reader);
            List<Integer> numberList = readList(reader);
            int k = readInt(reader);
            List<Integer> sum = getSum(numberList, k);
            for (int elem : sum) {
                writer.write(elem + " ");
            }
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.asList(reader.readLine().split(" "))
                .stream()
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
