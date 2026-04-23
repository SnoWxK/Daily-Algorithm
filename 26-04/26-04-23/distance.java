import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class distance {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> ij = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (ij.containsKey(nums[i])) {
                List<Integer> list = ij.get(nums[i]);
                list.add(i);
            } else {
                List<Integer> set = new ArrayList<>();
                set.add(i);
                ij.put(nums[i], set);
            }
        }
        long[] ans = new long[nums.length];
        for (Integer integer : ij.keySet()) {
            List<Integer> list = ij.get(integer);
            long[] prefix = new long[list.size()];
            if (list.size() == 1) continue;
            ;
            prefix[0] = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }
            for (int i = 0; i < list.size(); i++) {
                Integer index = list.get(i);
                long right = prefix[list.size() - 1] - prefix[i] - (long) index * (list.size() - 1 - i);
                long left = (long) index * (i + 1) - prefix[i];
                ans[index] = right + left;
            }
        }
        return ans;
    }
}
