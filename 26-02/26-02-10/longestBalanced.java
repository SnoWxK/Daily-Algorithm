
import java.util.HashSet;
import java.util.Set;

public class longestBalanced {
    public int longestBalanced(int[] nums) {
        int maxWindowSize = 0;
        for (int left = 0; left < nums.length; left++) {
            Set<Integer> odd = new HashSet<>();
            Set<Integer> even = new HashSet<>();
            for (int right = left; right < nums.length; right++) {
                if (nums[right] % 2 != 0) {
                    odd.add(nums[right]);
                } else {
                    even.add(nums[right]);
                }
                if (odd.size() == even.size()) {
                    maxWindowSize = Math.max(maxWindowSize, right - left + 1);
                }
            }
        }
        return maxWindowSize;
    }

}
