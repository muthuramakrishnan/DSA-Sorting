class Solution {

    public void reverseArray(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        reverseArray(nums);
        int largestPerimeter = 0;
        int n = nums.length;
        int i = n - 3, j = n - 2, k = n - 1;
        while (i >= 0) {
            if ((nums[i] + nums[j] > nums[k]) && (nums[i] + nums[k] > nums[j]) && (nums[j] + nums[k] > nums[i])) {
                largestPerimeter = Math.max(largestPerimeter, nums[i] + nums[j] + nums[k]);
            }
            i--;
            j--;
            k--;
        }
        return largestPerimeter;
    }
}
