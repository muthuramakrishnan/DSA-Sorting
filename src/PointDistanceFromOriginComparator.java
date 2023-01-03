import java.util.Comparator;
import java.util.Map;

public class PointDistanceFromOriginComparator implements Comparator<Map.Entry<Integer, Integer>> {
  public int compare(Map.Entry<Integer, Integer> x, Map.Entry<Integer, Integer> y) {
    int x1 = x.getKey();
    int y1 = x.getValue();
    int x2 = y.getKey();
    int y2 = y.getValue();

    int d1 = x1 * x1 + y1 * y1;
    int d2 = x2 * x2 + y2 * y2;

    return d1 - d2;
  }
}
