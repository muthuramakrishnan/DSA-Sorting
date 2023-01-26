import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetsLexicographically {
    public static void generateAllSubsets(String[] ipString, int currCharIdx, char[] outputArr, int outputIdx) {
        for (int i = 0; i < currCharIdx; i++) {
            System.out.print(outputArr[i] + " ");
        }
        System.out.println();
        if (outputIdx == ipString.length) {
            return;
        }


        for (int i = outputIdx; i < ipString.length; i++) {
            char currChar = ipString[i].charAt(0);
            outputArr[currCharIdx] = currChar;
            generateAllSubsets(ipString, currCharIdx + 1, outputArr, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        generateAllSubsets(s, 0, new char[s.length], 0);
    }
}
