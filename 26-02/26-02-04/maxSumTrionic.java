//3640. 三段式数组 II
//困难
//premium lock icon
//给你一个长度为 n 的整数数组 nums。
//三段式子数组 是一个连续子数组 nums[l...r]（满足 0 <= l < r < n），并且存在下标 l < p < q < r，使得：
//
//nums[l...p] 严格 递增，
//nums[p...q] 严格 递减，
//nums[q...r] 严格 递增。
//请你从数组 nums 的所有三段式子数组中找出和最大的那个，并返回其 最大 和。
//
//
//示例 1：
//
//输入：nums = [0,-2,-1,-3,0,2,-1]
//
//输出：-4
//
//解释：
//
//        选择 l = 1, p = 2, q = 3, r = 5：
//
//nums[l...p] = nums[1...2] = [-2, -1] 严格递增 (-2 < -1)。
//nums[p...q] = nums[2...3] = [-1, -3] 严格递减 (-1 > -3)。
//nums[q...r] = nums[3...5] = [-3, 0, 2] 严格递增 (-3 < 0 < 2)。
//和 = (-2) + (-1) + (-3) + 0 + 2 = -4。
//示例 2:
//
//输入: nums = [1,4,2,7]
//
//输出: 14
//
//解释:
//
//        选择 l = 0, p = 1, q = 2, r = 3：
//
//nums[l...p] = nums[0...1] = [1, 4] 严格递增 (1 < 4)。
//nums[p...q] = nums[1...2] = [4, 2] 严格递减 (4 > 2)。
//nums[q...r] = nums[2...3] = [2, 7] 严格递增 (2 < 7)。
//和 = 1 + 4 + 2 + 7 = 14。
//
//
//提示:
//
//        4 <= n = nums.length <= 105
//        -109 <= nums[i] <= 109
//保证至少存在一个三段式子数组。
public class maxSumTrionic {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        // 使用 long 防止溢出，初始化为极小值
        long INF = (long) 1e18;
        long[][] dp = new long[n][3];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = -INF;
        }

        long maxSum = -INF;

        for (int i = 1; i < n; i++) {
            // 状态 0: 严格递增 (l...p)
            if (nums[i] > nums[i - 1]) {
                // 可以是新起一段 (i-1, i)，也可以延续之前的递增
                dp[i][0] = Math.max((long)nums[i-1] + nums[i], dp[i-1][0] + nums[i]);
            }

            // 状态 1: 严格递减 (p...q)
            if (nums[i] < nums[i - 1]) {
                // 必须从状态 0 转移过来，或者延续状态 1
                long prev = Math.max(dp[i-1][0], dp[i-1][1]);
                if (prev > -INF) {
                    dp[i][1] = prev + nums[i];
                }
            }

            // 状态 2: 严格递增 (q...r)
            if (nums[i] > nums[i - 1]) {
                // 必须从状态 1 转移过来，或者延续状态 2
                long prev = Math.max(dp[i-1][1], dp[i-1][2]);
                if (prev > -INF) {
                    dp[i][2] = prev + nums[i];
                }
            }

            // 更新全局最大值（只有达到状态 2 才是完整的三段式）
            maxSum = Math.max(maxSum, dp[i][2]);
        }

        return maxSum;
    }
}
