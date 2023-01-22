import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSubarraySum1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine().strip());
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int low = i, high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if ((i > 0 && (prefixSum[mid] - prefixSum[i-1] < k)) || prefixSum[mid] < k) {
                    low = mid + 1;
                } else {
                    ans = Math.min(ans, mid-i+1);
                    high = mid - 1;
                }
            }
        }
        System.out.println(ans);
    }
}
