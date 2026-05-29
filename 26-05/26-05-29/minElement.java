public class minElement {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i : nums) {
            int sum = 0;
            while (i > 0) {
                sum += i % 10;
                i /= 10;
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }

}
