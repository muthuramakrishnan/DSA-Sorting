import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextGreaterPermutation {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static int searchForElJustGreater(int[] arr, int k, int low, int high) {
        int greaterElIdx = -1;
        for (int i = low; i <= high; i++) {
            if (arr[i] > k) {
                greaterElIdx = i;
            }
        }
        return greaterElIdx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int prev = Integer.MIN_VALUE;
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (arr[i] < prev) {
                break;
            }
            prev = arr[i];
        }
        if (i == -1) {
            reverse(arr, 0, n - 1);
            System.out.println(Arrays.toString(arr));
            System.exit(0);
        }
        int idx = searchForElJustGreater(arr, arr[i], i, n - 1);
        swap(arr, i, idx);
//        for (int j = i+1; n % 2 == 0 ? j < n / 2 - 1 : j < n / 2; j++) {
//            swap(arr, n - (j - i), j);
//        }
        Arrays.sort(arr, i + 1, n);
        System.out.println(Arrays.toString(arr));
    }
}
