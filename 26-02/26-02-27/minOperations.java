import java.util.*;

public class minOperations {
    public int minOperations(String s, int k) {
        int n = s.length(), m = 0;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<TreeSet<Integer>> nodeSets = new ArrayList<>();
        nodeSets.add(new TreeSet<>());
        nodeSets.add(new TreeSet<>());
        for (int i = 0; i <= n; i++) {
            nodeSets.get(i % 2).add(i);
            if (i < n && s.charAt(i) == '0') {
                m++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(m);
        dist[m] = 0;
        nodeSets.get(m % 2).remove(m);
        while (!q.isEmpty()) {
            m = q.poll();
            int c1 = Math.max(k - n + m, 0), c2 = Math.min(m, k);
            int lnode = m + k - 2 * c2, rnode = m + k - 2 * c1;
            TreeSet<Integer> nodeSet = nodeSets.get(lnode % 2);
            for (Integer m2 = nodeSet.ceiling(lnode); m2 != null && m2 <= rnode; m2 = nodeSet.ceiling(lnode)) {
                dist[m2] = dist[m] + 1;
                q.offer(m2);
                nodeSet.remove(m2);
            }
        }
        return dist[0] == Integer.MAX_VALUE ? -1 : dist[0];
    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/minimum-operations-to-equalize-binary-string/solutions/3906195/shi-er-jin-zhi-zi-fu-chuan-quan-wei-1-de-2z1u/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
