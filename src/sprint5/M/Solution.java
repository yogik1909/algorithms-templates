package sprint5.M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] heap = new int[Integer.parseInt(reader.readLine())];
        int i = 0;
        for (String num:reader.readLine().split(" ")){
            heap[i] = Integer.parseInt(num);
            i++;
        }
        int iter = Integer.parseInt(reader.readLine());
        for (i = 0; i < iter; i++) {
            String[] com = reader.readLine().split(" ");
            int n = Integer.parseInt(com[0]);
            int oper = Integer.parseInt(com[1]);
            heap[n - 1] += oper;
            System.out.println(siftUp(heap, n));
        }
        for (int num:heap){
            System.out.print(String.valueOf(num) + " ");
        }

    }
    public static int siftUp(int[] heap, int idx) {
        if (idx == 1) {
            return idx;
        }

        int indexParent = idx / 2;
        if (heap[indexParent - 1] < heap[(idx - 1)]) {
            heap[indexParent - 1] += heap[idx - 1];
            heap[idx - 1] = heap[indexParent - 1] - heap[idx - 1];
            heap[indexParent - 1] -= heap[idx - 1];
            return siftUp(heap, indexParent);
        }
        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        assert siftUp(sample, 5) == 1;
    }
}