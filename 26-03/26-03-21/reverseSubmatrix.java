import java.util.ArrayList;
import java.util.List;

public class reverseSubmatrix {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] temp = new int[k][k];
        for (int i = 0; i < k; i++) {
            System.arraycopy(grid[x + i], y + 0, temp[i], 0, k);
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(temp[i]);
        }
        for (int i = 0; i < k; i++) {
            temp[i] = list.get(k - 1 - i);
        }
        for (int i = 0; i < k; i++) {
            System.arraycopy(temp[i], 0, grid[x + i], y + 0, k);
        }
        return grid;
    }
}
