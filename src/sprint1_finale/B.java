package sprint1_finale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxTouchKey = Integer.parseInt(reader.readLine())*2;
            int maxBall = 0;
            char oneChar = '0';
            //char dot = '.';
            int curSumKey;
            int[] sumKyes = new int[10];
            for (int field = 0; field != 4 ; field++){
                char[] arrLine = reader.readLine().replaceAll("\\.", "").toCharArray();
                for( char eml:arrLine){

                    curSumKey = sumKyes[eml-oneChar];
                    if(curSumKey == 0) maxBall++;
                    if (++curSumKey == maxTouchKey + 1) { maxBall--; }
                    sumKyes[eml-oneChar] = curSumKey;
                }
            }
        System.out.println(maxBall);
    }
}
