import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class CustomObj {
  int value;
  int idx;
  int freq;

  CustomObj(int value, int idx, int freq) {
    this.value = value;
    this.idx = idx;
    this.freq = freq;
  }
}

class FreqComparator implements Comparator<CustomObj> {
  @Override
  public int compare(CustomObj o1, CustomObj o2) {
    if (o1.freq != o2.freq) {
      return o1.freq - o2.freq;
    }
    if (o1.value != o2.value) {
      return o1.value - o2.value;
    }
    return o1.idx - o2.idx;
  }
}

public class SortBasedonFrequency {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = s.length;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }

    int[] freqArr = new int[101];
    CustomObj[] customObjArr = new CustomObj[n];
    for (Integer i : arr) {
      freqArr[i]++;
    }
    for (int i = 0; i < n; i++) {
      customObjArr[i] = new CustomObj(arr[i], i, freqArr[arr[i]]);
    }

    Arrays.sort(customObjArr, new FreqComparator());

    for (int i = 0; i < n; i++) {
      System.out.print(customObjArr[i].value +" ");
    }
  }
}
