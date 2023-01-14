import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Rotations {
    String leftRotation = "leftRotation";
    String rightRotation = "rightRotation";
}

public class NextGreaterPermutationBruteForce {

    public static void rotate(int[] arr, String rotationType, int from, int to, int unit) {
        if (rotationType == Rotations.rightRotation) {
            while (unit >= 1) {
                int temp = arr[to];
                for (int i = to - 1; i >= from; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[from] = temp;
                unit--;
            }
        }
    }

    public static void generateAllPermutations(int[] arr, int currElIdx, int secondElIdx, List<List<Integer>> outputList) {
        if (currElIdx == arr.length) {
            List<Integer> permut = new ArrayList<>();
            for (int i = 0; i < secondElIdx; i++) {
                permut.add(arr[i]);
            }
            outputList.add(permut);
            return;
        }
        for (int i = secondElIdx; i < arr.length; i++) {
            rotate(arr, Rotations.rightRotation, currElIdx, i, 1);
            generateAllPermutations(arr, currElIdx + 1, secondElIdx + 1, outputList);
            rotate(arr, Rotations.rightRotation, currElIdx, i, 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] origArr = Arrays.copyOf(arr, n);
        List<List<Integer>> outputList = new ArrayList<>();
        int currElIdx = 0, secondElIdx = 0;
        generateAllPermutations(arr, currElIdx, secondElIdx, outputList);
        int idx = -1;
        for (int i = 0; i < outputList.size(); i++) {
            List<Integer> permutation = outputList.get(i);
            for (int j = 0; j < n; j++) {
                if (origArr[j] != permutation.get(j)) {
                    break;
                }
                if (j == n - 1) {
                    idx = i + 1;
                }
            }
            if (idx != -1) {
                break;
            }
        }
        System.out.println(outputList.get(idx));
    }
}
