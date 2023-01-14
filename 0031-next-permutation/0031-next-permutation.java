class Solution {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public int searchForElJustGreater(int[] arr, int k, int low, int high) {
        int greaterElIdx = -1;
        for (int i = low; i <= high; i++) {
            if (arr[i] > k) {
                greaterElIdx = i;
            }
        }
        return greaterElIdx;
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int prev = Integer.MIN_VALUE;
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (arr[i] < prev) {
                break;
            }
            prev = arr[i];
        }
        if (i == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        int idx = searchForElJustGreater(arr, arr[i], i, n - 1);
        swap(arr, i, idx);
        //        for (int j = i+1; n % 2 == 0 ? j < n / 2 - 1 : j < n / 2; j++) {
        //            swap(arr, n - (j - i), j);
        //        }
        // Arrays.sort(arr, i + 1, n);
        reverse(arr, i + 1, n - 1);
        // System.out.println(Arrays.toString(arr));
    }
}
