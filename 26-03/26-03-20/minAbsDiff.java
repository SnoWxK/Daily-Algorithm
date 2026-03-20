import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class minAbsDiff {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                List<Integer> temp = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        temp.add(grid[x][y]);
                    }
                }
                int min = Integer.MAX_VALUE;
                Collections.sort(temp);
                for (int t = 1; t < temp.size(); t++) {
                    if (temp.get(t).equals(temp.get(t - 1))) {
                        continue;
                    }
                    min = Math.min(min, temp.get(t) - temp.get(t - 1));
                }
                if (min != Integer.MAX_VALUE) {
                    ans[i][j] = min;
                }
            }
        }
        return ans;
    }
}
