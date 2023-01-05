class NumDetails {
    int myNum;
    int rank;

    NumDetails(int myNum, int rank) {
        this.myNum = myNum;
        this.rank = rank;
    }
}
class NumDetailComparator implements Comparator<NumDetails>{
    public int compare(NumDetails a, NumDetails b){
        if(a.rank == Integer.MAX_VALUE && b.rank == Integer.MAX_VALUE){
            return a.myNum - b.myNum;
        }
        else{
            return a.rank - b.rank;
        }
    }
}
class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ranks = new int[10001];
        for (int i = 0; i < 10001; i++) {
            ranks[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < arr2.length; i++) {
            ranks[arr2[i]] = i;
        }
        
        NumDetails[] numDetails = new NumDetails[arr1.length];
        for(int i=0; i<arr1.length; i++){
            NumDetails numDetail = new NumDetails(arr1[i], ranks[arr1[i]]);
            numDetails[i] = numDetail;
        }
        Arrays.sort(numDetails, new NumDetailComparator());
        for(int i=0; i<arr1.length; i++){
            arr1[i] = numDetails[i].myNum;
        }
        return arr1;
    }
}
