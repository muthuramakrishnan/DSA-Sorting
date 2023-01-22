import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSubarraySum {

    public static int findMaxSum(int[] arr, int windowSize) {
        int n = arr.length;
        int maxSum;
        int sum = 0;
        int i;
        for (i = 0; i < windowSize; i++) {
            sum += arr[i];
        }
        maxSum = sum;
        while (i < n) {
            sum += arr[i];
            sum -= arr[i - windowSize];
            maxSum = Math.max(maxSum, sum);
            i++;
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine().strip());
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        //binary search on ans
        int low = 0, high = n - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxSum = findMaxSum(arr, mid);
            if (maxSum < k) {
                low = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                high = mid - 1;

            }
        }
        System.out.println(ans);
    }
}
