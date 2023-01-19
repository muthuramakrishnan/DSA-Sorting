import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximizeTheIndexDifference {
    public static void main(String[] args) throws IOException {
        //Find elements greater than or equal to arr[i]
        //but out of all, the answer should have maximum difference between the indexs
        //bruteforace approach

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        //i loop chooses the min element
        //j loop chooses the max element
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[j] >= arr[i]) {
                    maxDiff = Math.max(j - i, maxDiff);
                }
            }
        }
        System.out.println(maxDiff);
    }
}
