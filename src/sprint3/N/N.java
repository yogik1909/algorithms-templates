package sprint3.N;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class N {
    public static void main(String[] args) throws IOException {
        int n;
        int[][] arria;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            arria = new int[n][2];
            for (int i = 0; i < n; i++){
                String[] a = reader.readLine().split(" ");
                arria[i] [0] = Integer.parseInt(a[0]);
                arria[i] [1] = Integer.parseInt(a[1]);
            }
        }
        
        int[][] res= mergeSort(arria);
        StringBuilder sb = new StringBuilder("");
        for (int[] a:res){
            sb.append(a[0]).append(" ").append(a[1]).append("\n");
        }
        System.out.println(sb);
    }
    
    public static int[][] mergeSort(int[][] array) {
        if (array.length == 1) {  // базовый случай рекурсии
            return array;
        }

        // запускаем сортировку рекурсивно на левой половине
        int[][] left = mergeSort(Arrays.copyOfRange(array, 0, array.length/2));

        // запускаем сортировку рекурсивно на правой половине
        int[][] right = mergeSort(Arrays.copyOfRange(array, array.length/2, array.length));

        // заводим массив для результата сортировки
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[2]);
        int[] curClumb= arr.get(0);
        // сливаем результаты
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            int[]curDo = new int[2];
            if (left[l][0] == right[r][0]){
                if (left[l][1] - left[l][0] <= right[r][1] - right[r][0]){
                    curDo[0] = left[l][0];
                    curDo[1] = left[l][1];
                    l++;
                }else {
                    curDo[0] = right[r][0];
                    curDo[1] = right[r][1];
                    r++;
                }
            } else if (left[l][0] < right[r][0]) {
                curDo[0] = left[l][0];
                curDo[1] = left[l][1];
                l++;
            }else {
                curDo[0] = right[r][0];
                curDo[1] = right[r][1];
                r++;
            }

            if (curClumb[0] == 0 && curClumb[1] == 0){
                curClumb[0] = curDo[0];
                curClumb[1] = curDo[1];
            }else if(curClumb[0] <= curDo[0] && curDo[0] <= curClumb[1] ){
                curClumb[1] = Math.max(curClumb[1], curDo[1]);
            }else {
                curClumb= new int[]{curDo[0], curDo[1]};
                arr.add(curClumb);

            }
        }
        while(l < left.length){
            if(curClumb[0] <= left[l][0] && left[l][0] <= curClumb[1] ){
                curClumb[1] = Math.max(curClumb[1], left[l][1]);
            }else {
                curClumb= new int[]{left[l][0], left[l][1]};
                arr.add(curClumb);

            }
            l++;
        }
        while (r < right.length){
            if(curClumb[0] <= right[r][0] && right[r][0] <= curClumb[1]  ){
                curClumb[1] = Math.max(curClumb[1], right[r][1]);
            }else {
                curClumb= new int[]{right[r][0], right[r][1]};
                arr.add(curClumb);

            }
            r++;
        }

        return arr.toArray(new int[arr.size()][2]);
    }
}

