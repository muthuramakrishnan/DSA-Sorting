import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KefaAndCompany {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tempString = br.readLine().split(" ");
        int n = Integer.parseInt(tempString[0]);
        int d = Integer.parseInt(tempString[1]);

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            tempString = br.readLine().split(" ");
            arr[i] = new Pair(Integer.parseInt(tempString[0]), Integer.parseInt(tempString[1]));
        }

//        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        long ans = 0;
        long currentSum = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < n) {
            if (arr[endIdx].amount - arr[startIdx].amount < d) {
                currentSum += arr[endIdx].friendFactor;
                endIdx++;
            } else {
                currentSum -= arr[startIdx].friendFactor;
                startIdx++;
            }
            ans = Math.max(currentSum, ans);
        }
        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair> {
    int amount;
    int friendFactor;

    Pair(int amount, int friendFactor) {
        this.amount = amount;
        this.friendFactor = friendFactor;
    }

    @Override
    public int compareTo(Pair o) {
        return this.amount - o.amount;
    }

    public String toString() {
        return "[" + this.amount + ", " + this.friendFactor + "]";
    }

}
