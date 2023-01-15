import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class DescendingValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getKey() - o1.getKey();
    }
}

public class AdvantageArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = s.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a);
        List<Map.Entry<Integer, Integer>> valuePositionListOfB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> valuePosition = new AbstractMap.SimpleEntry<>(b[i], i);
            valuePositionListOfB.add(valuePosition);
        }
        Collections.sort(valuePositionListOfB, new DescendingValueComparator());
        int smallPtr = 0, largePtr = n - 1;
        for (int i = 0; i < n; i++) {
            int value = valuePositionListOfB.get(i).getKey();
            int position = valuePositionListOfB.get(i).getValue();
            if (a[largePtr] > value) {
                output[position] = a[largePtr];
                largePtr--;
            } else {
                output[position] = a[smallPtr];
                smallPtr++;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
