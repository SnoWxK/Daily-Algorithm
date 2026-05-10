public class maximumJumps {
    public int maximumJumps(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(nums[j] - nums[i]) <= target){
                    if (dp[j] == 0 && j != 0) continue;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1] == 0 ? -1 : dp[len - 1];
    }
}
