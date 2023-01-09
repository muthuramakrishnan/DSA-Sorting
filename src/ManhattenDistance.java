import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ManhattenDistance {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i<n; i++){
            x[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            y[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int totalSumX = 0;
        int totalSumY = 0;
        for(int i=0; i<n; i++){
            totalSumX += x[i];
            totalSumY += y[i];
        }
        int result = 0;
        for(int i=0; i<n; i++){
            totalSumX -= x[i];
            result += totalSumX - ((n-i) * x[i]);
            totalSumY -= y[i];
            result += totalSumY - ((n-i) * y[i]);
        }
        System.out.println(result);
    }
}
