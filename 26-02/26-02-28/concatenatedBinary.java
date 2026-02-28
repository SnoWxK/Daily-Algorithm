public class concatenatedBinary {
    public int concatenatedBinary(int n) {
        long res = 0;
        int MOD = 1_000_000_007;
        int shift = 0;

        for (int i = 1; i <= n; i++) {
            // 如果 i 是 2 的幂（如 2, 4, 8...），说明二进制长度增加了
            // (i & (i - 1)) == 0 是判断 2 的幂的经典位运算技巧
            if ((i & (i - 1)) == 0) {
                shift++;
            }

            // 核心公式：res = (res << shift | i) % MOD
            res = ((res << shift) | i) % MOD;
        }

        return (int) res;
    }
}
