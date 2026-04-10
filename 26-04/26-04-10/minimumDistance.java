public class minimumDistance {
    public int minimumDistance(int[] nums) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == nums[i]) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[k] == nums[j]) {
                            int distance = (k - i) * 2;
                            result = Math.min(result, distance);
                        }
                    }
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}
