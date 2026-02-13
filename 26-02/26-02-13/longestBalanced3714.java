import java.util.*;

public class longestBalanced3714 {
    private int case2Helper(String s, char x, char y) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != x && s.charAt(i) != y) {
                continue;
            }

            Map<Integer, Integer> h = new HashMap<>();
            h.put(0, i - 1);
            int diff = 0;
            int j = i;
            while (j < n && (s.charAt(j) == x || s.charAt(j) == y)) {
                diff += (s.charAt(j) == x) ? 1 : -1;
                Integer prev = h.get(diff);
                if (prev != null) {
                    res = Math.max(res, j - prev);
                } else {
                    h.put(diff, j);
                }
                j++;
            }
            i = j - 1;
        }
        return res;
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int res = 0;

        // 情况一，仅包括一种字符
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                last++;
            } else {
                last = 1;
            }
            res = Math.max(res, last);
        }

        // 情况二，包含两种字符
        res = Math.max(res, case2Helper(s, 'a', 'b'));
        res = Math.max(res, case2Helper(s, 'b', 'c'));
        res = Math.max(res, case2Helper(s, 'a', 'c'));

        // 情况三，包含三种字符 - 优化：使用自定义键对象
        class Key {
            final int x, y;
            Key(int x, int y) {
                this.x = x;
                this.y = y;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Key key = (Key) o;
                return x == key.x && y == key.y;
            }
            @Override
            public int hashCode() {
                return 31 * x + y;
            }
        }

        Map<Key, Integer> h = new HashMap<>();
        h.put(new Key(n, n), -1);

        int diffAB = 0;
        int diffBC = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                diffAB--;
            } else if (c == 'b') {
                diffAB++;
                diffBC++;
            } else {
                diffBC--;
            }

            Key key = new Key(diffAB + n, diffBC + n);
            Integer prev = h.get(key);
            if (prev != null) {
                res = Math.max(res, i - prev);
            } else {
                h.put(key, i);
            }
        }
        return res;
    }
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/longest-balanced-substring-ii/solutions/3896558/zui-chang-de-ping-heng-zi-chuan-ii-by-le-0g8o/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//    超时
//    public int longestBalanced(String s) {
//        int maxWindowSize = 0;
//        for (int left = 0; left < s.length(); left++) {
//            int num_a = 0;
//            int num_b = 0;
//            int num_c = 0;
//            for(int right = left; right < s.length(); right++){
//                if(s.charAt(right) == 'a'){
//                    num_a++;
//                }else if(s.charAt(right) == 'b'){
//                    num_b++;
//                }else{
//                    num_c++;
//                }
//                Set<Integer> set = new HashSet<>();
//                if (num_a != 0) set.add(num_a);
//                if (num_b != 0) set.add(num_b);
//                if (num_c != 0) set.add(num_c);
//
//                if (set.size() == 1) {
//                    maxWindowSize = Math.max(maxWindowSize, right - left + 1);
//                }
//            }
//        }
//        return maxWindowSize;
//    }
}
