import java.util.TreeSet;

public class getBiggestThree {
    int N = 110;
    int[][] s1 = new int[N][N];
    int[][] s2 = new int[N][N];
    public int[] getBiggestThree(int[][] g){
        int n = g.length;
        int m = g[0].length;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                s1[i][j] = s1[i - 1][j - 1] + g[i - 1][j - 1];
                s2[i][j] = s2[i - 1][j + 1] + g[i - 1][j - 1];
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                set.add(g[i - 1][j - 1]);
                for(int k = 1; i - k >= 1 && i + k <= n && j - k >= 1 && j + k <= m; k ++){
                    int a = s2[i][j - k] - s2[i - k][j];
                    int b = s1[i][j + k] - s1[i - k][j];
                    int c = s2[i + k][j] - s2[i][j + k];
                    int d = s1[i + k][j] - s1[i][j - k];
                    set.add(a + b + c + d - g[i + k - 1][j - 1] + g[i - k - 1][j - 1]);
                }
                while(set.size() > 3){
                    set.pollFirst();
                }
            }
        }
        if(set.size() == 1){
            return new int[]{set.pollFirst()};
        }
        if(set.size() == 2){
            return new int[]{set.pollLast(),set.pollLast()};
        }
        return new int[]{set.pollLast(),set.pollLast(),set.pollLast()};
    }
}
