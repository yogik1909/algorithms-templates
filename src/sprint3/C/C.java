package sprint3.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static boolean StgringIsConstaint(String orig, String pod){
        if (orig.length() < pod.length()) {
            return false;
        }
        if (orig.substring(0, pod.length() - 1).equals(pod)) {
            return true;
        } else {
            return StgringIsConstaint(orig.substring(1, orig.length() - 1), pod);
        }

    }
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String pod = reader.readLine();
            String orig = reader.readLine();
            System.out.println(StgringIsConstaint(orig, pod)?"True":"False");

        }
        catch (IOException e){

        }
    }
}
