import java.util.Arrays;

public class Solution {
	public static int[] merge(int[] arr, int left, int mid, int right) {
		int cur_left = left;
		int cur_right = mid;
		int to = 0;

		int[] temp_arr = new int[right - left];

		while (cur_left < mid && cur_right < right){
			if (arr[cur_left] <= arr[cur_right]){
				temp_arr[to] = arr[cur_left];
				cur_left++;
			}else {
				temp_arr[to] = arr[cur_right];
				cur_right++;
			}
			to++;
		}
		while (cur_left < mid){
			temp_arr[to] = arr[cur_left];
			cur_left++;
			to++;
		}
		while (cur_right < right){
			temp_arr[to] = arr[cur_right];
			cur_right++;
			to++;
		}
		System.arraycopy(temp_arr, 0, arr, left, right - left);
		return arr;
	}

	public static void merge_sort(int[] arr, int left, int right) {
		if (right - left >= 2){
			int mid = (right + left)>>1;
			merge_sort(arr, left, mid);
			merge_sort(arr, mid , right);
			merge(arr, left, mid , right);
		}

	}

	public static void main(String[] args) {
		int[] a = {1, 4, 9, 2, 10, 11};
		int[] b = merge(a, 0, 3, 6);
		int[] expected = {1, 2, 4, 9, 10, 11};
		assert Arrays.equals(b, expected);
		int[] c = {1, 4, 2, 10, 1, 2};
		merge_sort(c, 0, 6);
		int[] expected2 = {1, 1, 2, 2, 4, 10};
		assert Arrays.equals(c, expected2);
	}
}