package sprint5.M;

public class Solution {
    public static void main(String[] args) {
        int[] sample = {12, 6, 8, 3, 15, 7};
        System.out.println(siftUp(sample, 5) == 1);
    }
    public static int siftUp(int[] heap, int idx) {
        int curIndex = idx - 1;
        if (idx == 1) {
            return idx;
        }

        int indexParent = curIndex >> 1;
        if (heap[indexParent] < heap[curIndex]) {
            int temp = heap[curIndex];
            heap[indexParent] = heap[curIndex];
            heap[curIndex] = temp;
            return siftUp(heap, indexParent + 1);
        }
        return curIndex + 1;
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        assert siftUp(sample, 5) == 1;
    }
}