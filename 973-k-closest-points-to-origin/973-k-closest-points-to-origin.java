class Solution {
    class FreqArrComparator implements Comparator<int[]>{
        public int compare(int[] a, int b[]){
            int x1 = a[0];
            int y1= a[1];
            int x2 = b[0];
            int y2 = b[1];
            
            int d1 = x1 * x1 + y1 * y1;
            int d2 = x2 * x2 + y2 * y2;
            return d1 - d2;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Arrays.sort(points, new FreqArrComparator());
        return Arrays.copyOfRange(points, 0, k);
    }
}