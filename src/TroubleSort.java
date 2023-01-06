import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TroubleSort {
  public static void troubleSort(int[] arr) {
    int n = arr.length;
    boolean done = false;
    while (!done) {
      done = true;
      int i = 0;
      while (i < n - 2) {
        if (arr[i] > arr[i + 2]) {
          int temp = arr[i];
          arr[i] = arr[i + 2];
          arr[i + 2] = temp;
          done = false;
        }
        i++;
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
    troubleSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
