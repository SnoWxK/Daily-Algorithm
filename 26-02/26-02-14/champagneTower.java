public class champagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = (double)poured;
        for(int i = 0; i < query_row; i++){
            for(int j = 0; j <= i; j++){
                flow(dp, i, j);
            }
            if(dp[i][(i+1)/2] ==0){
                break;
            }
        }
        return Math.min(dp[query_row][query_glass],1.0);
    }
    public void flow(double[][] dp, int row, int col) {
        if (dp[row][col] > 1) {
            double excess = (dp[row][col] - 1) / 2;
            dp[row][col] = 1;
            dp[row + 1][col] += excess;
            dp[row + 1][col + 1] += excess;
        }
    }
}
