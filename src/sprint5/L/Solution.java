package sprint5.L;

public class Solution {
    public static void main(String[] args) {
        int[] sample = {12, 1, 8, 3, 4, 7};
        System.out.println(siftDown(sample, 2) == 5);
    }
    public static int siftDown(int[] heap, int idx) {
        int idx_1 = idx - 1;
        int indLeftChild = idx * 2 - 1;
        int indRightChild = indLeftChild + 1;

        if (indLeftChild >= heap.length - 1) {return idx;}

        int indexLargest = idx_1;

        if (indLeftChild < heap.length - 1 && heap[indLeftChild] > heap[indexLargest]){
            indexLargest = indLeftChild;
        }

        if (indRightChild < heap.length - 1 && heap[indRightChild] > heap[indexLargest]) {
            indexLargest = indRightChild;
        }
        if (indexLargest != idx_1) {
            int temp = heap[idx_1];
            heap[idx_1]= heap[indexLargest];
            heap[indexLargest] = temp;
            return siftDown(heap, indexLargest)+1;
        }
        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 2) == 5;
    }
}