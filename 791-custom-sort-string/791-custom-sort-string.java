class CustomObj{
    char myChar;
    int rank;
    CustomObj(char myChar, int rank){
        this.myChar = myChar;
        this.rank = rank;
    }
}
class CustomObjComparator implements Comparator<CustomObj>{
    public int compare(CustomObj o1, CustomObj o2){
        return o1.rank - o2.rank;
    }
}
class Solution {
    public String customSortString(String order, String s) {
        int[] rank = new int[26];
        for(int i=0; i<order.length(); i++){
            rank[order.charAt(i) - 'a'] = i;
        }
        int n = s.length();
        CustomObj[] customObjArr = new CustomObj[n];
        for(int i=0; i<n; i++){
            CustomObj obj = new CustomObj(s.charAt(i), rank[s.charAt(i) - 'a']);
            customObjArr[i] = obj;
        }
        Arrays.sort(customObjArr, new CustomObjComparator());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(customObjArr[i].myChar);
        }
        return sb.toString();
    }
}