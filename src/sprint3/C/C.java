package sprint3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
        static boolean isFirstStringSeqString(String subString, String origString, int curIndSubStr, int curIndOrig)
        {
            // Base Cases
            if (curIndSubStr == 0)
                return true;
            if (curIndOrig == 0)
                return false;

            if (subString.charAt(curIndSubStr - 1) == origString.charAt(curIndOrig - 1))
                return isFirstStringSeqString(subString, origString, curIndSubStr - 1, curIndOrig - 1);

            return isFirstStringSeqString(subString, origString, curIndSubStr, curIndOrig - 1);
        }

    public static void main(String[] args) {
        String set, subSet;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            subSet = reader.readLine();
            set = reader.readLine();
            System.out.println(isFirstStringSeqString(subSet, set, subSet.length(), set.length())?"True":"False");

        }
        catch (IOException e){

        }
    }
}
