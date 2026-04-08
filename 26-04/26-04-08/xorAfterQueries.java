public class xorAfterQueries {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = (long) 1e9 + 7;
        for (int[] query : queries) {
            int l = query[0], r = query[1];
            int k = query[2], v = query[3];
            int idx = l;
            while (idx <= r) {
                long tmp = nums[idx];
                tmp = (tmp * v) % MOD;
                nums[idx] = (int) (tmp % MOD);
                idx += k;
            }
        }
        long ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return (int) ans;
    }
}
