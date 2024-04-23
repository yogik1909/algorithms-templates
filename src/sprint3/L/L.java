package sprint3.L;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L {
    public static void main(String[] args) throws IOException {
        int[] ans = new int[2];
        int coast, days;
        int[] aNac;
        String nac;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            days = Integer.parseInt(reader.readLine());
            aNac = new int[days];
            nac = reader.readLine();
            coast = Integer.parseInt(reader.readLine());
        }
        int i = 0;
        for (String dn:nac.split(" ")){
            aNac[i] = Integer.parseInt(dn);
            i++;
        }

        ans[0] = binarySearch(aNac, coast, 0, aNac.length, -2);
        ans[1] = binarySearch(aNac, coast*2, ans[0], aNac.length, -2);
        System.out.printf("%d %d", ans[0]+1, ans[1]+1);


    }

    public static int binarySearch(int[] arr, int x, int left, int right, int indCanBy) {
        if (right <= left) { // промежуток пуст
            return indCanBy;
        }
        int mid = (left + right) / 2;
        if (arr[mid] >= x) {  // центральный элемент — искомый
            indCanBy = mid;
            return binarySearch(arr, x, left, mid, indCanBy);
        } else {
            return binarySearch(arr, x, mid + 1, right, indCanBy);
        }
    }
}
