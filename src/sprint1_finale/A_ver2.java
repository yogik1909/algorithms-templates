//https://contest.yandex.ru/contest/22450/run-report/110811266/
package sprint1_finale;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class A_ver2 {

    private static List<Integer> getNeighb(List<Integer> numberList) {
        int k = numberList.size();
        List<Integer> neighb = new LinkedList<Integer>(Collections.nCopies(k, Integer.valueOf(0)));
        List<Integer> forwSteps = new LinkedList<Integer>(Collections.nCopies(k, Integer.valueOf(0)));
        List<Integer> backSteps = new LinkedList<Integer>(Collections.nCopies(k, Integer.valueOf(0)));
        int size = numberList.size() - 1;
        int forStep = size, backStep = size;


        for (int forwardIndex = 0, backIndex = size; forwardIndex <= size; forwardIndex++, backIndex--){
            boolean forwardNumberIsEmty = numberList.get(forwardIndex) == 0;
            boolean backNumberIsEmpty    = numberList.get(backIndex) == 0;

            boolean firstHalfLine = forwardIndex <=backIndex, overHalfLine = forwardIndex >= backIndex;

            if (forwardNumberIsEmty) forStep = 0;
            else if (firstHalfLine) forwSteps.set(forwardIndex,++forStep);
            else forStep++;

            if (backNumberIsEmpty) backStep = 0;
            else if (firstHalfLine) backSteps.set(backIndex, ++backStep);
            else backStep++;
            if (overHalfLine) {
                neighb.set(forwardIndex, Math.min(forStep, backSteps.get(forwardIndex)));
                neighb.set(backIndex, Math.min(backStep, forwSteps.get(backIndex)));
            }
        }

        return neighb;
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
