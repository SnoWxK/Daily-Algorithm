import java.util.LinkedList;
import java.util.Queue;

public class containsCycle {
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (!visited[i][j] && bfs(i, j, grid))
                    return true;
        return false;
    }

    private boolean bfs(int i, int j, char[][] grid) {
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int neibors = 0, size = queue.size();
            for (int[] dir : dirs) {
                int row = node[0] + dir[0], col = node[1] + dir[1];
                if (isValid(row, col) && grid[row][col] == grid[node[0]][node[1]]) {
                    ++neibors;
                    if (!visited[row][col]) {
                        queue.offer(new int[]{row, col});
                        visited[row][col] = true;
                    }
                }
            }
            if (neibors - 1 > queue.size() - size)
                return true;
        }
        return false;
    }

    int m, n;
    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean isValid(int i, int j) {
        return i >=0 && j >= 0 && i < m && j < n;
    }
}
