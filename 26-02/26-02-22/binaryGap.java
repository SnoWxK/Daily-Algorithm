public class binaryGap {
    public int binaryGap(int n) {
        int prev = -1;          // 上一个1的位置
        int maxDist = 0;
        int i = 0;              // 当前位置

        while (n > 0) {
            if ((n & 1) == 1) {  // 当前位是1
                if (prev != -1) {
                    maxDist = Math.max(maxDist, i - prev);
                }
                prev = i;
            }
            n >>= 1;             // 右移一位
            i++;
        }

        return maxDist;
    }
}
