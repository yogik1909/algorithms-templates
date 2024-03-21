import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B {

    private static List<Integer> zip(List<Integer> a, List<Integer> b) {
        int cap = a.size() + b.size();
        List<Integer> ret = new ArrayList<>(cap);
        int curIndIns = 0;
        for (int valAlrr_a: a){
            ret.add(valAlrr_a);
            ret.add(b.get(curIndIns));
            curIndIns++;
        }
        return ret;
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(reader.readLine());
            List<Integer> a = readList(reader);
            List<Integer> b = readList(reader);
            printList(zip(a, b), writer);
        }
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return  Arrays.asList(reader.readLine().split(" "))
                        .stream()
                        .map(elem -> Integer.parseInt(elem))
                        .collect(Collectors.toList());
    }

    private static<T> void printList(List<T> list, Writer writer) {
        list.forEach(elem -> {
                try {
                    writer.write(String.valueOf(elem));
                    writer.write(" ");
                } catch (IOException e) {
                    
                }
            }
        );
    }
}