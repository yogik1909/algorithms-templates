//https://contest.yandex.ru/contest/22450/problems/

package sprint1_finale;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static List<Integer> getNeighb(List<Integer> numberList) {

        List<Integer> neigh = new ArrayList<Integer>(Collections.nCopies(numberList.size(), 0));
        int entZero = 0; //+1
        int step = numberList.size();
        for (int ltIns = 0; ltIns < numberList.size(); ltIns++) {
            if(numberList.get(ltIns) == 0) {step = 1; entZero++; continue;}
            neigh.set(ltIns, step++);
        }
        for (int rghIns = numberList.size()-1; rghIns >= 0 || entZero > 0; rghIns--) {
            if(numberList.get(rghIns) == 0) {step = 1; entZero--; continue;}
            if (neigh.get(rghIns) > step )
                neigh.set(rghIns, step);
            step++;
        }

        return neigh;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            StringBuilder output_buffer = new StringBuilder();
            int numberOfHouses = readInt(reader);
            List<Integer> addressSpace = readList(reader);
            List<Integer> neighb = getNeighb(addressSpace);
            for (int elem : neighb) {
                output_buffer.append(elem).append(" ");
            }
            System.out.println(output_buffer.toString());
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