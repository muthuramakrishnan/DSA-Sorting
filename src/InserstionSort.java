import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InserstionSort {
  public static void insertionSort(int[] arr) {
    int n = arr.length;

    // lets consider one part of the array is sorted and the other is unsorted
    // so the first element is sorted
    for (int i = 1; i < n; i++) {
      int j = i;
      // look for the previous item
      // if the prev item is greater than the current swap
      // Then look for it's previous.. continue on & on until it is inserted into it's correct
      // position
      while (j >= 1 && arr[j - 1] > arr[j]) {
        int temp = arr[j - 1];
        arr[j - 1] = arr[j];
        arr[j] = temp;
        j--;
      }
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
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
