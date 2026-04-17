import java.util.HashMap;
import java.util.Map;

public class minMirrorPairDistance {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> prev = new HashMap<>();
        int n = nums.length;
        int ans = n + 1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (prev.containsKey(x)) {
                ans = Math.min(ans, i - prev.get(x));
            }
            prev.put(reverseNum(x), i);
        }

        return ans == n + 1 ? -1 : ans;
    }

    private int reverseNum(int x) {
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}
//public int minMirrorPairDistance(int[] nums) {
//    int[] reverseNums = new int[nums.length];
//    for (int i = 0; i < nums.length; i++) {
//        reverseNums[i] = reverse(nums[i]);
//    }
//    int result = Integer.MAX_VALUE;
//    boolean flag = false;
//    for (int i = 0; i < nums.length; i++) {
//        for (int j = i + 1; j < nums.length; j++) {
//            if (reverseNums[i] == nums[j]) {
//                result = Math.min(result, Math.abs(i - j));
//                flag = true;
//                if (result == 1) {
//                    return 1;
//                }
//            }
//        }
//    }
//    return flag ? result : -1;
//}
//
//private int reverse(int n) {
//    int rev = 0;
//    while (n > 0) {
//        rev = rev * 10 + n % 10;
//        n /= 10;
//    }
//    return rev;
//}