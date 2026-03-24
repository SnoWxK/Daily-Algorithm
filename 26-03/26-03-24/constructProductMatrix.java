public class constructProductMatrix {
    public int[][] constructProductMatrix(int[][] matrix) {
        int MOD = 12345;

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] p = new int[n][m];

        long pre = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) pre;
                pre = (pre * (matrix[i][j] % MOD)) % MOD;
            }
        }

        long suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) ((p[i][j] * suf) % MOD);
                suf = (suf * (matrix[i][j] % MOD)) % MOD;
            }
        }

        return p;
    }
}
