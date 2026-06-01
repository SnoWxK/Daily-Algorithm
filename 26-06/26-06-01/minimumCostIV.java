import java.util.Arrays;

public class minimumCostIV {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int num = 0;
        int len = cost.length;
        int totalCost = 0;
        for (int i = len - 1; i >= 0; i--) {
            num++;
            if (num % 3 == 0) {
                continue;
            }
            totalCost += cost[i];
        }
        return totalCost;
    }
}
