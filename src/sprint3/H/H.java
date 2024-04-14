package sprint3.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class H {
    public static void main(String[] args) throws IOException {
        int n;
        String[] argz;
        BigInteger[] bi;
        LinkedList <Integer> res = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
            bi = new BigInteger[n];
            argz = reader.readLine().split(" ");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(argz));
            AllCombinations(list, "", res);
            System.out.println(Collections.max(res));
        }



    }

    static void AllCombinations(LinkedList<String> arr, String cur, LinkedList<Integer> resList){
        if (arr.size() == 0){
//            System.out.println(cur);
            resList.add(Integer.parseInt(cur));
            return;
        }
        for (int i = 0; i < arr.size() ; i++) {
            LinkedList<String> newArr = (LinkedList<String>) arr.clone();
            newArr.remove(i);
            AllCombinations(newArr, cur + arr.get(i), resList);
        }

    }
}
