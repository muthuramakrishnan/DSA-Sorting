import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortingInANumberLine {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = s.length;
    List<Map.Entry<Integer, Integer>> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(s[i].split(",")[0]);
      int b = Integer.parseInt(s[i].split(",")[1]);
      points.add(new AbstractMap.SimpleEntry<>(a, b));
    }
    System.out.println(points);
    Collections.sort(points, new PointDistanceFromOriginComparator());
    System.out.println(points);
  }
}
