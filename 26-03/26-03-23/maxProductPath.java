public class maxProductPath {
    public int maxProductPath(int[][] grid) {
        int mod = 1000000007;
        int m = grid.length;
        int n = grid[0].length;

        //到达[i][j]的最大乘积
        long[][] dpMax = new long[m][n];
        //到达[i][j]的最小乘积
        long[][] dpMin = new long[m][n];

        //起点
        dpMax[0][0] = dpMin[0][0] = grid[0][0];

        //第一行
        for (int i = 1; i < n; i++) {
            dpMax[0][i] = dpMin[0][i] = dpMax[0][i - 1] * grid[0][i];
        }
        //第一列
        for (int i = 1; i < m; i++) {
            dpMax[i][0] = dpMin[i][0] = dpMax[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i][j - 1]) * grid[i][j];
                    dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i][j - 1]) * grid[i][j];
                } else {
                    dpMax[i][j] = Math.min(dpMin[i - 1][j], dpMin[i][j - 1]) * grid[i][j];
                    dpMin[i][j] = Math.max(dpMax[i - 1][j], dpMax[i][j - 1]) * grid[i][j];
                }
            }
        }

        long res = dpMax[m - 1][n - 1];

        return res < 0 ? -1 : (int) (res % mod);
    }
}
