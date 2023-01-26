import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximizeTheIndexDiffereceOptimized {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        Pair1[] arr = new Pair1[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair1(Integer.parseInt(s[i]), i);
        }

        Arrays.sort(arr);

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = arr[n - 1].oldIdx;
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(arr[i].oldIdx, suffixMax[i + 1]);
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            maxVal = Math.max(suffixMax[i + 1] - arr[i].oldIdx, maxVal);
        }

        System.out.println(maxVal);

    }
}

class Pair1 implements Comparable<Pair1> {
    int val;
    int oldIdx;

    Pair1(int val, int oldIdx) {
        this.val = val;
        this.oldIdx = oldIdx;
    }

    public int compareTo(Pair1 p1) {
        if (this.val == p1.val) {
            return this.oldIdx - p1.oldIdx;
        }
        return this.val - p1.val;
    }
}