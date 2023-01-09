import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SextuplesBruteforce {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    for(int l=0; l<n; l++){
                        if(arr[l]!=0){
                            for(int m=0; m<n; m++){
                                for(int o=0; o<n; o++){
                                    double lhs = ((arr[i] * arr[j] + arr[k]) / arr[l]) - arr[m];
                                    if(lhs == arr[o]){
                                        ans++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
