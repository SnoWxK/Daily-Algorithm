import java.util.Arrays;

public class maximumAmount {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        long[][][] dp = new long[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Long.MIN_VALUE / 2);
            }
        }

        dp[0][0][0] = coins[0][0]; // 不感化
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;       // 感化 1 次
            dp[0][0][2] = 0;       // 感化 2 次（虽然起点只用 1 次，但为了逻辑连续性）
        } else {
            dp[0][0][1] = coins[0][0];
            dp[0][0][2] = coins[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {
                    long fromPrev = Long.MIN_VALUE / 2;
                    if (i > 0) fromPrev = Math.max(fromPrev, dp[i - 1][j][k]);
                    if (j > 0) fromPrev = Math.max(fromPrev, dp[i][j - 1][k]);

                    dp[i][j][k] = Math.max(dp[i][j][k], fromPrev + coins[i][j]);

                    if (k > 0 && coins[i][j] < 0) {
                        long fromPrevLess = Long.MIN_VALUE / 2;
                        if (i > 0) fromPrevLess = Math.max(fromPrevLess, dp[i - 1][j][k - 1]);
                        if (j > 0) fromPrevLess = Math.max(fromPrevLess, dp[i][j - 1][k - 1]);

                        dp[i][j][k] = Math.max(dp[i][j][k], fromPrevLess);
                    }
                }
            }
        }
        long res = Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
        return (int)res;
    }
}
