public class minSwaps {
    public int minSwaps(int[][]  grid){
        int n=grid.length;
        int[] pos=new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0){
                    count++;
                }else {
                    break;
                }
            }
            pos[i]=count;
        }
        int result=0;
        for(int i=0;i<n;i++){
            int target=n-i-1;
            int found=-1;
            for(int j=i;j<n;j++){
                if(pos[j]>=target){
                    found=j;
                    break;
                }
            }
            if(found==-1){
                return -1;
            }
            for(int j=found;j>i;j--){
                int temp=pos[j];
                pos[j]=pos[j-1];
                pos[j-1]=temp;
                result++;
            }
        }
        return result;
    }
}
