import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RangeQuery1 {

    public static int binarySearch(int[] prefixSum, int key, int low, int high) {
        int n = prefixSum.length;
        int i = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(prefixSum[mid] - prefixSum[i] > key){
                if(prefixSum[mid-1] - prefixSum[i] <=key ){
                    return mid+1;
                }
                high = mid-1;
            }
             else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
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

        int[] voteArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= n - 2) {
                int breakPoint = binarySearch(prefixSum, arr[i], i + 1, n - 1);
                voteArr[breakPoint]--;
                voteArr[i+1]++;
            }
            if(i>=1){
                int breakPoint = binarySearch(prefixSum, arr[i], 0, i-1);
                voteArr[breakPoint]--;
                voteArr[i]--;
            }

        }
        System.out.println(voteArr);
        for (int i = 0; i < n; i++) {
            arr[i] += voteArr[i];
        }
        System.out.println(Arrays.toString(arr));
    }
}
