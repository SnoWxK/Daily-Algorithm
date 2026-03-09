public class numberOfStableArrays {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long MOD = 1_000_000_007;
        // dp[i][j][k] 表示用了 i 个 0，j 个 1，末尾为 k 的方案数
        long[][][] dp = new long[zero + 1][one + 1][2];

        // 初始化：只放 0 或只放 1 且长度不超过 limit 的情况
        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // 状态转移：末尾放 0
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // 减去末尾连续出现 limit + 1 个 0 的非法情况
                    // 即减去 dp[i-limit-1][j][1]
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // 状态转移：末尾放 1
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    // 减去末尾连续出现 limit + 1 个 1 的非法情况
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
