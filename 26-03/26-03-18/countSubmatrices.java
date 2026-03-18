public class countSubmatrices {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[] colSum = new int[cols];

        for (int i = 0; i < rows; i++) {
            int rowAndColSum = 0;
            for (int j = 0; j < cols; j++) {
                colSum[j] += grid[i][j];
                rowAndColSum += colSum[j];
                if (rowAndColSum <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
