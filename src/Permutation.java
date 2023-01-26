import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutation {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void generateAllPermutation(int[] arr, int size, int idx) {
        if (idx == size) {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = idx; i < size; i++) {
            swap(arr, idx, i);
            generateAllPermutation(arr, size, idx + 1);
            swap(arr, idx, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        generateAllPermutation(arr, arr.length, 0);
    }
}
