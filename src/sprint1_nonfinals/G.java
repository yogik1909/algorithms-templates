package sprint1_nonfinals;

import javafx.beans.binding.StringBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class G {

    private static String getBinaryNumber(int n) {
        StringBuilder strBuild = new StringBuilder();
        int rem = n;
        while (rem > 1){
            strBuild.insert(0, rem % 2);
            rem /= 2;
        }
        strBuild.insert(0, rem);
        return strBuild.toString();
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            System.out.println(getBinaryNumber(n));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
