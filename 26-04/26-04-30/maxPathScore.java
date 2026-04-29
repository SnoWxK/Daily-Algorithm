import java.util.Arrays;

public class maxPathScore {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[n + 1][k + 1];
        for (int[] row : f)
            Arrays.fill(row, Integer.MIN_VALUE);
        Arrays.fill(f[1], 0);
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                int x = row[j];
                int c = x == 0 ? 0 : 1;
                for (int v = k - c; v >= 0; v--) {
                    f[j + 1][v + c] = Math.max(f[j + 1][v], f[j][v]) + x;
                }
                if (c == 1)
                    f[j + 1][0] = Integer.MIN_VALUE;
            }
        }
        return f[n][k] < 0 ? -1 : f[n][k];
    }
}
