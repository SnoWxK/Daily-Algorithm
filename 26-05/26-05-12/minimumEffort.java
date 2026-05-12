import java.util.Arrays;

public class minimumEffort {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a, b)->{return (a[1]-a[0])-(b[1]-b[0]);});
        int ans=0;
        for(var t:tasks){
            ans=Math.max(ans+t[0],t[1]);
        }
        return ans;
    }
}
