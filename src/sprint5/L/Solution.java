package sprint5.L;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] heap = new int[Integer.parseInt(reader.readLine())];
        int i = 0;
        for (String num : reader.readLine().split(" ")) {
            heap[i] = Integer.parseInt(num);
            i++;
        }
        int iter = Integer.parseInt(reader.readLine());
        for (i = 0; i < iter; i++) {
            String[] com = reader.readLine().split(" ");
            int n = Integer.parseInt(com[0]);
            int oper = Integer.parseInt(com[1]);
            heap[n - 1] -= oper;
            System.out.println(siftDown(heap, n));
        }
        for (int num : heap) {
            System.out.print(String.valueOf(num) + " ");
        }

    }

    public static int siftDown(int[] heap, int idx) {
        int indLeftChild = idx * 2;
        int indRightChild = indLeftChild + 1;

        if (indLeftChild >= heap.length - 1) {
            return idx;
        }

        int indexLargest = idx;

        if (indLeftChild < heap.length && heap[indLeftChild - 1] > heap[indexLargest - 1]) {
            indexLargest = indLeftChild;
        }

        if (indRightChild < heap.length && heap[indRightChild - 1] > heap[indexLargest - 1]) {
            indexLargest = indRightChild;
        }
        if (indexLargest != idx) {
            int temp = heap[idx - 1];
            heap[idx - 1] = heap[indexLargest - 1];
            heap[indexLargest - 1] = temp;
            return siftDown(heap, indexLargest);
        }
        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 2) == 5;
    }
}