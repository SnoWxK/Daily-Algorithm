public class maxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int['z' + 1];
        for (char ch : text.toCharArray()) {
            cnt[ch]++;
        }
        return min(cnt['a'], cnt['b'], cnt['l'] / 2, cnt['n'], cnt['o'] / 2);
    }

    private int min(int... nums) {
        int res = nums[0];
        for (int x : nums) {
            res = Math.min(res, x);
        }
        return res;
    }
}
