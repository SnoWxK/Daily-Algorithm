import java.util.Arrays;

public class maxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int len = costs.length;
        int i=0;
        for(;i<len;i++){
            sum += costs[i];
            if(sum>coins){
                break;
            }
        }
        return i;
    }
}
