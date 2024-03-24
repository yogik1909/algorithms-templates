package sprint1_nonfinals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class H {
    private static String sumOfBinaries(String a, String b) {
        boolean over = false;
        char[] oper1, oper2;
        StringBuilder res = new StringBuilder();
        int diff = a.length() - b.length();
        if (diff != 0) {
            String add = null;
            if (diff > 0) {
                add = b;
                oper1 = a.toCharArray();
            }
            else{
                add = a;
                oper1 = b.toCharArray();
            }
            StringBuilder sb = new StringBuilder(add);

            for (int i = 0; i < Math.abs(diff); i++) {
                sb.insert(0, "0");
            }
            oper2 = sb.toString().toCharArray();

        }
        else {
            oper1 = a.toCharArray();
            oper2 = b.toCharArray();
        }
        int curSum;
        char f = '0';
        for (int i = oper1.length-1; i >= 0 ; i--){
            curSum = (oper1[i] - f) + (oper2[i] - f) + (over?1:0);
            over = false;
            switch (curSum){
                case 0: res.insert(0, '0'); break;
                case 1: res.insert(0, '1'); break;
                case 2: res.insert(0, '0'); over = true; break;
                case 3: res.insert(0, '1'); over = true; break;
        }

    }
        res.insert(0, over?"1":"");
        return res.toString();
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String a = reader.readLine();
            String b = reader.readLine();
            System.out.println(sumOfBinaries(a, b));
        }
    }
}
