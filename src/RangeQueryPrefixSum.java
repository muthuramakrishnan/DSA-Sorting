import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class QueryPair {
    int a;
    int b;

    QueryPair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class RangeQueryPrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        QueryPair[] queries = new QueryPair[q];
        for (int i = 0; i < q; i++) {
            s = br.readLine().split(" ");
            queries[i] = new QueryPair(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        for (QueryPair query : queries) {
            arr[query.b]++;
            if (query.a > 0) {
                arr[query.a - 1]--;
            }
        }

        int[] suffixSum = new int[n];
        suffixSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }
        System.out.println(Arrays.toString(suffixSum));
    }
}
