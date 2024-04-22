import java.util.Arrays;

public class Solution {
	public static int[] merge(int[] arr, int left, int mid, int right) {

		if (arr.length == 1) {return arr;}




		return null;
	}

	public static void merge_sort(int[] arr, int left, int right) {
		int curRigth = right -1;
		if (curRigth - left == 1) return;
		merge_sort(arr, left + 1, curRigth);
		if (arr[left] > arr[curRigth]) {
			arr[curRigth] = arr[left] + arr[curRigth];
			arr[left] = arr[curRigth] - arr[left];
			arr[curRigth] = arr[curRigth] - arr[left];
		}

	}

	public static void main(String[] args) {
//		int[] a = {1, 4, 9, 2, 10, 11};
//		int[] b = merge(a, 0, 3, 6);
//		int[] expected = {1, 2, 4, 9, 10, 11};
//		assert Arrays.equals(b, expected);
		int[] c = {1, 4, 2, 10, 1, 2};
		merge_sort(c, 0, 6);
		int[] expected2 = {1, 1, 2, 2, 4, 10};
		assert Arrays.equals(c, expected2);
	}
}