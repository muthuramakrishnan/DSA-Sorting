import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SextupleOptimized {
    public static int findFreq(int key, List<Integer> bucket){
        int lowIdx = -1;
        int highIdx = -1;
        int n = bucket.size();
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(bucket.get(mid) == key && (mid == 0 || bucket.get(mid-1)!=key)){
                lowIdx = mid;
                break;
            }
            if(bucket.get(mid) < key){
               low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        low = 0;
        high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(bucket.get(mid) == key && (mid == n-1 || bucket.get(mid+1)!=key)){
                highIdx = mid;
                break;
            }
            if(bucket.get(mid) > key){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        if(lowIdx==-1){
            return 0;
        }
        return highIdx - lowIdx + 1;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        //given equation  ((a * b + c) / d) - e = f;

        //first find triplets -> a * b + c = d * (e+f);
        List<Integer> bucket1 = new ArrayList<>();
        List<Integer> bucket2 = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    bucket1.add(arr[i] * arr[j] + arr[k]);
                    if(arr[i]!=0){
                        bucket2.add(arr[i] * (arr[j] + arr[k]));
                    }
                }
            }
        }
        Collections.sort(bucket2);
        System.out.println(bucket1 +" " + bucket2);
        Iterator<Integer> i = bucket1.iterator();
        int result = 0;
        while(i.hasNext()){
            int elem = i.next();
            int freq = findFreq(elem, bucket2);
            result += freq;
        }
        System.out.println(result);
    }
}
