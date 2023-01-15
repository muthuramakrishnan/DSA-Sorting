class DescendingValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getKey() - o1.getKey();
    }
}

class Solution {

    public int[] advantageCount(int[] a, int[] b) {
        int n = a.length;
        Arrays.sort(a);
        List<Map.Entry<Integer, Integer>> valuePositionListOfB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> valuePosition = new HashMap.SimpleEntry<>(b[i], i);
            valuePositionListOfB.add(valuePosition);
        }
        Collections.sort(valuePositionListOfB, new DescendingValueComparator());
        int smallPtr = 0, largePtr = n - 1;
        int[] output = new int[n];
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
        return output;
    }
}
