package sprint1_finale;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static List<Integer> getNeighb(List<Integer> numberList, int k) {

        List<Integer> neighb = new ArrayList<Integer>(Collections.nCopies(k, 0));
        boolean emptyFounded = false;
        int moveRigt = 1;
        for (int ltIns = 0; ltIns < numberList.size(); ltIns++) {
            if (numberList.get(ltIns) != 0) {
                if (emptyFounded) neighb.set(ltIns, moveRigt++);
                continue;
            }
            emptyFounded = true;


            for (int j = 1;
                 ltIns - j >= 0
                         && numberList.get(ltIns - j) != 0
                         && (neighb.get(ltIns - j) == 0 || j < neighb.get(ltIns - j));
                 j++)
                neighb.set(ltIns - j, j);
            moveRigt = 1;

        }




        return neighb;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringBuilder output_buffer = new StringBuilder();
            int numberOfHouses = readInt(reader);
            List<Integer> addressSpace = readList(reader);
            List<Integer> neighb = getNeighb(addressSpace, numberOfHouses);
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