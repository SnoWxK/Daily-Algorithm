public class rotateTheBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            int wall = n;
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    cnt = 0;
                    wall = j;
                }
                if (boxGrid[i][j] == '#') {
                    cnt++;
                    boxGrid[i][j] = '.';
                    boxGrid[i][wall - cnt] = '#';
                }
            }
        }
        char[][] res = new char[n][m];
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                res[j][m - i - 1] = boxGrid[i][j];
            }
        }
        return res;
    }
}
