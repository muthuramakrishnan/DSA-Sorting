class CustomComparator implements Comparator<Integer> {

    public int compare(Integer a, Integer b) {
        String val1 = a.toString() + b.toString();
        String val2 = b.toString() + a.toString();

        return Long.parseLong(val2) - Long.parseLong(val1) < 0 ? -1 : 1;
    }
}

class Solution {

    public Integer[] toObject(int[] intArray) {
        int n = intArray.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(intArray[i]);
        }
        return arr;
    }

    public String largestNumber(int[] nums) {
        Integer[] intObjArr = toObject(nums);
        Arrays.sort(intObjArr, new CustomComparator());
        if(intObjArr[0] == 0){
            return "0";
        }
        StringBuilder s = new StringBuilder();
        for (Integer i : intObjArr) {
            s.append(i);
        }
        return s.toString();
    }
}
