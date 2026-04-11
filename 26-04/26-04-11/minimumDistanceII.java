import java.util.*;

public class minimumDistanceII {
    public int minimumDistance(int[] nums){
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> numToIndices = new HashMap<Integer, List<Integer>>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            numToIndices.putIfAbsent(nums[i], new ArrayList<Integer>());
            numToIndices.get(nums[i]).add(i);
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = numToIndices.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            List<Integer> indices = entry.getValue();
            int size = indices.size();
            for (int i = 2; i < size; i++) {
                int distance = (indices.get(i) - indices.get(i - 2)) * 2;
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance != Integer.MAX_VALUE ? minDistance : -1;
    }
}
