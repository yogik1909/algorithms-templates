package sprint3_final.A;

public class Solution {
    public static int brokenSearch(int[] arr, int k) {

        switch (arr.length) {
            case 0: {return -1;}
            case 1: {return k == arr[0]?0:-1;}
            case 2: {return k==arr[0]?0:k == arr[1]?1:-1;}
        }


        int startInd;

        int mid = arr.length >> 1;
        if (arr[0] < arr[mid] && arr[mid] < arr[arr.length - 1]){
            return binarySearch(arr, k, 0, arr.length);
        }  else {
            startInd = binarySearchMin(arr, 0, arr.length);
        }

        int ResIndex = binarySearch(arr, k, 0, startInd);
        if (ResIndex == -1 ) {ResIndex = binarySearch(arr, k, startInd, arr.length);}

        return ResIndex;

    }

    public static int binarySearchMin(int[] arr, int left, int right) {
        if (right - left > 2) {
            int mid = (left + right) >> 1;
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) return mid;
            if (arr[left] > arr[mid]) {
                return binarySearchMin(arr, left, mid);
            }
            return binarySearchMin(arr, mid, right);
        } else if (right - left == 2) {
            return arr[right-1] > arr[left] ? left : right;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int val, int left, int right) {
        if (right <= left) { // промежуток пуст
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] == val) {
            return mid;
        } else if (val < arr[mid]) {
            return binarySearch(arr, val, left, mid);
        } else {
            return binarySearch(arr, val, mid + 1, right);
        }
    }

    private static void test() {
//        int[] arr = {19,    21,  100,    101,    1,  4,  5,  7,  12};
//        System.out.println(binarySearchMin(arr, 0, arr.length));

//        System.out.println("Seach: 4 = "+brokenSearch(arr, 4));
//        System.out.println("Seach: 100 = "+brokenSearch(arr, 100));
//        arr = new int[]{101,   1,   4,      5,      7,  12, 19, 21, 100};
//        System.out.println(binarySearchMin(arr, 0, arr.length));
//        arr = new int[]{100, 101, 1, 4, 5, 7, 12, 19, 21};
//        System.out.println(binarySearchMin(arr, 0, arr.length));
        //assert 6 == brokenSearch(arr, 5);
        int[] arr = {5, 1};
        System.out.println(brokenSearch(arr, 1));

    }

    public static void main(String[] args) {
        test();
    }
}
