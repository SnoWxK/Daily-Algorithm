import java.util.ArrayList;
import java.util.List;

public class numSpecial {
    public int numSpecial(int[][] mat) {
        int count=0;
        int countSum;
        List< Integer> indexRow=new ArrayList<>();
        List< Integer> indexCol=new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            countSum=0;
            for(int j=0;j<mat[0].length;j++){
                countSum+=mat[i][j];
            }
            if(countSum==1){
                indexRow.add(i);
            }
        }
        for(int j=0;j<mat[0].length;j++){
            countSum=0;
            for(int i=0;i<mat.length;i++){
                countSum+=mat[i][j];
            }
            if(countSum==1){
                indexCol.add(j);
            }
        }
        for(int i:indexRow){
            for(int j:indexCol){
                if(mat[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
