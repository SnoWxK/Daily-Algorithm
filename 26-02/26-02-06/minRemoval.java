import java.util.Arrays;

public class minRemoval {
    public int minRemoval(int[] nums, int k) {
        if(nums.length==1)
        {
            return 0;
        }
        Arrays.sort(nums);

        int n=nums.length;
        int maxWindowSize=0;
        int left=0;
        for(int right=0;right<n;right++)
        {
            while ((long)nums[right] > (long)nums[left] * k) {
                left++;
            }
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }
        return n - maxWindowSize;
    }
}
