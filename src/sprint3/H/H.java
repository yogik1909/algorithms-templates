package sprint3.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class H {
    public static void main(String[] args) throws IOException {
        int n;
        String[] argz;
        LinkedList <String> res = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
            argz = reader.readLine().split(" ");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(argz));
            Collections.sort(list);


            AllCombinations(list, "", res);
            System.out.println(res.get(0));
        }
    }

    static void AllCombinations(LinkedList<String> arr, String cur, LinkedList<String> resList){
        if (arr.size() == 0){
            resList.add(cur);
            return;
        }
        Collections.sort(arr);
        LinkedList<String> newArr = (LinkedList<String>) arr.clone();
        newArr.remove(arr.size()-1);
        AllCombinations(newArr, cur + arr.get(arr.size()-1), resList);
    }
}
