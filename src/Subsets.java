import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsets {
    public static void generateAllSubsets(String[] ipString, int currCharIdx, char[] outputArr, int outputIdx){
        if(currCharIdx == ipString.length){
            for(int i=0; i<outputIdx; i++){
                System.out.print(outputArr[i]+" ");
            }
            System.out.println();
            return;
        }
//        outputArr[outputIdx] = Character.MIN_VALUE;
        generateAllSubsets(ipString, currCharIdx+1, outputArr, outputIdx);
        char currChar = ipString[currCharIdx].charAt(0);
        outputArr[outputIdx] = currChar;
        generateAllSubsets(ipString, currCharIdx+1, outputArr, outputIdx+1);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        generateAllSubsets(s, 0, new char[s.length], 0);
    }
}
