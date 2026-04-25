import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class maxDistanceIII {
    public int maxDistance(int side, int[][] points, int k) {
        List<Long> arr = new ArrayList<>();

        for (int[] p : points) {
            int x = p[0], y = p[1];
            if (x == 0) {
                arr.add((long) y);
            } else if (y == side) {
                arr.add((long) side + x);
            } else if (x == side) {
                arr.add(side * 3L - y);
            } else {
                arr.add(side * 4L - x);
            }
        }
        Collections.sort(arr);

        long lo = 1, hi = side;
        int ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(arr, side, k, mid)) {
                lo = mid + 1;
                ans = (int) mid;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(List<Long> arr, int side, int k, long limit) {
        long perimeter = side * 4L;

        for (long start : arr) {
            long end = start + perimeter - limit;
            long cur = start;

            for (int i = 0; i < k - 1; i++) {
                int idx = lowerBound(arr, cur + limit);
                if (idx == arr.size() || arr.get(idx) > end) {
                    cur = -1;
                    break;
                }
                cur = arr.get(idx);
            }

            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }

    private int lowerBound(List<Long> arr, long target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/maximize-the-distance-between-points-on-a-square/solutions/3957467/zheng-fang-xing-shang-de-dian-zhi-jian-d-vqlb/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
