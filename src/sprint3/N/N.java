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
        for (int[] a:res){
            if (a[1] == 0) continue;
            System.out.printf("%d %d", a[0], a[1]);
            System.out.println();
        }
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
        int[][] result = new int[array.length][2];
        // сливаем результаты
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            int lengthVecКуы = result[l][1] - result[l][0];
            int lengthVecLeft = left[l][1] - left[l][0];
            int lengthVecRight = right[l][1] - right[l][0];
            if (left[l][0] == right[l][0] || left[l][1] == right[l][1]) {
                result[k] = lengthVecLeft >= lengthVecRight?left[l]:right[r];
                l++;
                r++;
            } else if (left[l][1] == right[r][0]) {
                result[k][0] = left[l][0];
                result[k][1] = right[r][1];
                l++;
                r++;
            } else if (right[r][1] == left[l][0]) {
                result[k][0] = right[r][0];
                result[k][1] = left[l][1];
                l++;
                r++;
            } else if(left[l][0] < right[r][0]){
                result[k] = left[l];

                if (left[l][1] > right[r][0]) {
                    result[k][1] = Math.max(left[l][1], right[r][1]);
                    r++;}
                l++;

            } else if (right[r][0] < left[l][0]){
                result[k] = right[r];

                if (right[r][1] > left[l][0]){
                result[k][1] = Math.max(left[l][1], right[r][1]);
                l++;}
                r++;
            }
            
            k++;
        }
        
        while (l < left.length) {
            int lengthVecLeft = left[l][1] - left[l][0];
            int lengthVecRes = result[l][1] - result[l][0];
            if ((left[l][0] == result[l][0] || left[l][1] == result[l][1]) 
                    && lengthVecLeft == lengthVecRes ) {
                l++;
                continue;} else if () {
                
            }
        }
        while (r < right.length) {
            result[k] = right[r];  // перенеси оставшиеся элементы right в result
            r++;
            k++;
        }
        return result;
    }
}

