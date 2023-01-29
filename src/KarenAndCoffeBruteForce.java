import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class MinMaxTemparaturePair {
    int minTemp;
    int maxTemp;

    MinMaxTemparaturePair(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
}

public class KarenAndCoffeBruteForce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int q = Integer.parseInt(s[2]);

        MinMaxTemparaturePair[] pairArr = new MinMaxTemparaturePair[n];
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            pairArr[i] = new MinMaxTemparaturePair(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            minVal = Math.min(minVal, pairArr[i].minTemp);
            maxVal = Math.max(maxVal, pairArr[i].maxTemp);
        }

        int tempArrSize = maxVal - minVal + 1;
        int[] tempArr = new int[tempArrSize];
        for (int i = 0; i < n; i++) {
            tempArr[pairArr[i].minTemp - minVal]++;
            if (tempArrSize > pairArr[i].maxTemp - minVal + 1) {
                tempArr[pairArr[i].maxTemp + 1 - minVal]--;
            }
        }
//        System.out.println(Arrays.toString(tempArr));

        int[] prefixSum = new int[tempArrSize];
        prefixSum[0] = tempArr[0];
        for(int i=1; i<tempArrSize; i++){
            prefixSum[i] = prefixSum[i-1] + tempArr[i];
        }

        while(q>=1){
            s = br.readLine().split(" ");
            int min = Integer.parseInt(s[0]);
            int max = Integer.parseInt(s[1]);
            int count = 0;
            for(int i = min; i<=max; i++){
                if(i-minVal >=0 && i-minVal<tempArrSize && prefixSum[i-minVal]>=k){
                    count++;
                }
            }
            System.out.println(count);
            q--;
        }
    }
}
