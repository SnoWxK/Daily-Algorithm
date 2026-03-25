import java.util.Arrays;

public class canPartitionGrid {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long totalSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
            }
        }

        if (totalSum % 2 != 0) return false;
        long target = totalSum / 2;

        long currentRowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                currentRowSum += grid[i][j];
            }
            if (currentRowSum == target) return true;
            if (currentRowSum > target) break;
        }

        long currentColSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                currentColSum += grid[i][j];
            }
            if (currentColSum == target) return true;
            if (currentColSum > target) break;
        }

        return false;
    }
}
