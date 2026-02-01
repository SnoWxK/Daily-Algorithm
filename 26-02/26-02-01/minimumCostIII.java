public class minimumCostIII {
    public  int minCost(int[] nums) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];
        int minCost = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = nums[0] + nums[i] + nums[j];
                minCost = Math.min(minCost,cost);
            }
        }
        return minCost;
    }
}
