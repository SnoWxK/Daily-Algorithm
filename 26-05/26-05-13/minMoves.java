public class minMoves {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] delta = new int[limit * 2 + 2];
        for (int i = 0; i < n / 2; ++i) {
            int low = 1 + Math.min(nums[i], nums[n - i - 1]);
            int high = limit + Math.max(nums[i], nums[n - i - 1]);
            int sum = nums[i] + nums[n - i - 1];
            delta[low]--;
            delta[sum]--;
            delta[sum + 1]++;
            delta[high + 1]++;
        }
        int now = n;

        int ans = n;
        for (int i = 2; i <= limit * 2; ++i) {
            now += delta[i];
            ans = Math.min(ans, now);
        }
        return ans;
    }
}
