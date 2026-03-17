import java.util.Arrays;

public class largestSubmatrix {
    public  int largest(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] height=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    if(i==0)
                        height[i][j]=1;
                    else
                        height[i][j]=height[i-1][j]+1;
                }
                else
                    height[i][j]=0;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int[] currentRow = height[i].clone();
            Arrays.sort(currentRow);
            for (int j = n - 1; j >= 0; j--) {
                if (currentRow[j] == 0) break;
                int width = n - j;
                int area = currentRow[j] * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
