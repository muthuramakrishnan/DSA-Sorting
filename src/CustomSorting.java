import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class CustomObj1 {
  char myChar;
  int rank;

  CustomObj1(char myChar, int rank) {
    this.myChar = myChar;
    this.rank = rank;
  }
}

class CustomComparator implements Comparator<CustomObj1> {
  public int compare(CustomObj1 a, CustomObj1 b) {
    return a.rank - b.rank;
  }
}

public class CustomSorting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] s = br.readLine().strip().toCharArray(); // input should be entered without spaces
    char[] t = br.readLine().strip().toCharArray();
    //    System.out.println(Arrays.toString(s));
    int[] rank = new int[26];
    Arrays.fill(rank, Integer.MAX_VALUE);
    for (int i = 0; i < s.length; i++) {
      rank[s[i] - 'a'] = i;
    }
    CustomObj1[] customObjArr = new CustomObj1[t.length];
    for (int i = 0; i < t.length; i++) {
      CustomObj1 obj = new CustomObj1(t[i], rank[t[i] - 'a']);
      customObjArr[i] = obj;
    }
    Arrays.sort(customObjArr, new CustomComparator());
    for (int i = 0; i < t.length; i++) {
      System.out.print(customObjArr[i].myChar + " ");
    }
  }
}
