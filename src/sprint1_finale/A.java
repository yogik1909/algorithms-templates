package sprint1_finale;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class A {

    private static List<Integer> getNeighb(List<Integer> numberList, int k) {
        List<Integer> neighb = new LinkedList<Integer>(Collections.nCopies(k, Integer.valueOf(0)));
        List<Integer> forwSteps = new LinkedList<Integer>(Collections.nCopies(k, Integer.valueOf(0)));
        List<Integer> backSteps = new LinkedList<Integer>(Collections.nCopies(k, Integer.valueOf(0)));
        int size = numberList.size() - 1;
        int forStep = size, backStep = size;


        for (int forwardIndex = 0, backIndex = size; forwardIndex <= size; forwardIndex++, backIndex--){
            int forwardNumber = numberList.get(forwardIndex);
            int backNumber    = numberList.get(backIndex);

            if (forwardNumber != 0){
                if( forwardIndex < backIndex) {
                    forwSteps.set(forwardIndex, forStep++);
                }

                if(forwardIndex >= backIndex){
                    int backRes = backSteps.get(forwardIndex);
                    neighb.set(forwardIndex, forStep < backRes?forStep : backRes);
                    forStep++;
                }



            }else forStep = 1;


            if (backNumber != 0){
                if ( backIndex > forwardIndex) {
                    backSteps.set(backIndex, backStep++);
                }

                if (backIndex <= forwardIndex){
                    int forRes = forwSteps.get(backIndex);
                    neighb.set(backIndex, forStep < forRes?backStep : forRes);
                    backStep++;
                }
            }else backStep = 1;









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
            //long startTime = System.currentTimeMillis();
            List<Integer> neighb = getNeighb(addressSpace, numberOfHouses);
            //long time = System.currentTimeMillis() ;
            for (int elem : neighb) {
                output_buffer.append(elem).append(" ");
            }
            System.out.println(output_buffer.toString());
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
