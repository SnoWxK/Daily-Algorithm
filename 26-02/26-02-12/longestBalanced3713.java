import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class longestBalanced3713 {
    public int longestBalanced(String s) {
        int maxWindowSize = 0;
        for (int left = 0; left < s.length(); left++) {
            Map<Character, Integer> map = new HashMap<>();

            for (int right = left; right < s.length(); right++) {
                map.merge(s.charAt(right), 1, Integer::sum);
                //比较集合中所有value,若均相等则更新maxWindowSize
                Collection<Integer> values = map.values();
                Integer first = null;
                boolean allEqual = true;
                for (Integer val : values) {
                    if (first == null) {
                        first = val;
                    } else if (!val.equals(first)) {
                        allEqual = false;
                        break;  // 发现不相等立即终止
                    }
                }
                if (allEqual) {
                    maxWindowSize = Math.max(maxWindowSize, right - left + 1);
                }
            }
        }
        return maxWindowSize;
    }
}
