import java.util.Arrays;

public class minimumDistanceIII {
    static final int INFINITY = Integer.MAX_VALUE / 2;
    static final int TOTAL = 26;
    static final int COLUMNS = 6;

    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n][TOTAL][TOTAL];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < TOTAL; j++) {
                Arrays.fill(dp[i][j], INFINITY);
            }
        }
        int start = word.charAt(0) - 'A';
        for (int k = 0; k < TOTAL; k++) {
            dp[0][start][k] = 0;
        }
        for (int j = 0; j < TOTAL; j++) {
            dp[0][j][start] = 0;
        }
        for (int i = 1; i < n; i++) {
            int prev = word.charAt(i - 1) - 'A';
            int curr = word.charAt(i) - 'A';
            int distance = getDistance(prev, curr);
            for (int k = 0; k < TOTAL; k++) {
                dp[i][curr][k] = Math.min(dp[i][curr][k], dp[i - 1][prev][k] + distance);
            }
            for (int j = 0; j < TOTAL; j++) {
                dp[i][j][curr] = Math.min(dp[i][j][curr], dp[i - 1][j][prev] + distance);
            }
            for (int k = 0; k < TOTAL; k++) {
                dp[i][prev][curr] = Math.min(dp[i][prev][curr], dp[i - 1][prev][k] + getDistance(k, curr));
            }
            for (int j = 0; j < TOTAL; j++) {
                dp[i][curr][prev] = Math.min(dp[i][curr][prev], dp[i - 1][j][prev] + getDistance(j, curr));
            }
        }
        int minDistance = INFINITY;
        for (int j = 0; j < TOTAL; j++) {
            for (int k = 0; k < TOTAL; k++) {
                minDistance = Math.min(minDistance, dp[n - 1][j][k]);
            }
        }
        return minDistance;
    }

    public int getDistance(int position1, int position2) {
        int x1 = position1 / COLUMNS, y1 = position1 % COLUMNS;
        int x2 = position2 / COLUMNS, y2 = position2 % COLUMNS;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
