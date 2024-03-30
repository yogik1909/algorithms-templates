package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A {

    static List<List<Integer>> getTraporentMatrix(List<List<Integer>> matrix, int coRows, int coCol) {
        List<List<Integer>> matrixTr = new ArrayList<>(coCol);
        for (int indCol = 0; indCol < coCol; indCol++){
            matrixTr.add(new ArrayList<Integer>(coRows));
        }
        int indRow = 0;
        for (List<Integer> curRow:matrix){
            int indCol = 0;
            for (int curValCol:curRow){
                matrixTr.get(indCol++).add(curValCol);
            }
            indRow++;
        }

        return matrixTr;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder();
            int rowsCount = readInt(reader);
            int colsCount = readInt(reader);
            List<List<Integer>> matrix = readMatrix(reader, rowsCount);
            List<List<Integer>> matrixT = getTraporentMatrix(matrix, rowsCount, colsCount);
            for (List<Integer> curRow:matrixT){
                for (int val:curRow){
                    stringBuilder.append(val).append(" ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder);

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

    private static List<List<Integer>> readMatrix(BufferedReader reader, int rowsCount) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>(rowsCount);
        for (int i = 0; i < rowsCount; i++) {
            matrix.add(readList(reader));
        }
        return matrix;
    }
}
