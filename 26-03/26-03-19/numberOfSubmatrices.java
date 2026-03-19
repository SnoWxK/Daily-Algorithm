public class numberOfSubmatrices {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        int[] colSumX = new int[cols];
        int[] colSumY = new int[cols];

        for (int i = 0; i < rows; i++) {
            int sumX = 0;
            int sumY = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'X') {
                    colSumX[j]++;
                }
                if (grid[i][j] == 'Y') {
                    colSumY[j]++;
                }
                sumX += colSumX[j];
                sumY += colSumY[j];
                if (sumX == sumY && sumX != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
