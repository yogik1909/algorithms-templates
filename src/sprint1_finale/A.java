package sprint1_finale;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static List<Integer> getNeighb(List<Integer> numberList, int k) {
        List<Integer> emptyIndexes = new LinkedList<>();
        int empIndex = 0;
        for (Integer val:numberList){
            if(val == 0){emptyIndexes.add(empIndex);}
            empIndex++;
        }
        List<Integer> neighb = new LinkedList<Integer>(Collections.nCopies(k, Integer.valueOf(0)));
        if (emptyIndexes.size() == neighb.size()
            || emptyIndexes.size() == 0) return neighb;

        int leftIndex, rightIndex;
        for (int i = 1; i <= emptyIndexes.size()-1; i++){
            leftIndex = emptyIndexes.get(i-1);
            rightIndex = emptyIndexes.get(i);
                int diff = rightIndex - leftIndex;
                int div = diff / 2;
                for (int offset = 1; offset <= div; offset++){
                    neighb.set(leftIndex +offset, offset);
                    neighb.set(rightIndex-offset, offset);
                }
        }
        rightIndex = emptyIndexes.get(0);
        for (int i = 0, rad = rightIndex; i < rightIndex ; i++, rad--) {
            neighb.set(i, rad);
        };
        rightIndex = neighb.size()-1;
        leftIndex = emptyIndexes.get(emptyIndexes.size()-1);
        for (int i = leftIndex+1, rad = 1; i <= rightIndex ; i++, rad++) {
            neighb.set(i, rad);
        }



        return neighb;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberOfHouses = readInt(reader);
            List<Integer> addressSpace = readList(reader);
            //long startTime = System.currentTimeMillis();
            List<Integer> neighb = getNeighb(addressSpace, numberOfHouses);
            //long time = System.currentTimeMillis() ;
            for (int elem : neighb) {
                writer.write( elem + " ");
            }
            //writer.write("Time:"+(time - startTime));
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
