package sprint3_final.A;

public class Solution {
    public static int brokenSearch(int[] arr, int k) {

    }
    public static int seachMin(int[] arr){
        int min = Integer.MAX_VALUE;

    }

    public static int binarySearchMin(int[] arr, int left, int right) {
        if (right <= left) { // промежуток пуст
            return -1;
        }
        // промежуток не пуст
        int mid = (left + right) / 2;
        if (arr[mid] == min) {  // центральный элемент — искомый
            return mid;
        } else if (min < arr[mid]) { // искомый элемент меньше центрального значит следует искать в левой половине
            return binarySearchMin(arr, min, left, mid);
        } else { // иначе следует искать в правой половине
            return binarySearchMin(arr, min, mid + 1, right);
        }
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        assert 6 == brokenSearch(arr, 5);
    }
}
