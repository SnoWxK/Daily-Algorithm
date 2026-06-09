import java.util.Arrays;

public class pivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, pivot);
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < pivot) {
                ans[left] = nums[i];
                ++left;
            } else if (nums[i] > pivot) {
                ans[right] = nums[i];
                --right;
            }
        }
        reverse(ans, right + 1, n - 1);
        return ans;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
