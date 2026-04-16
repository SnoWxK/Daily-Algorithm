import java.util.*;

public class solveQueries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        // 1. 预处理：记录每个值对应的所有下标列表
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> answer = new ArrayList<>();
        for (int targetIdx : queries) {
            int val = nums[targetIdx];
            List<Integer> positions = posMap.get(val);

            // 如果该数字只出现了一次，不存在“其他”相等元素
            if (positions.size() <= 1) {
                answer.add(-1);
                continue;
            }

            // 2. 二分查找当前下标在位置列表中的索引
            int currPosInList = Collections.binarySearch(positions, targetIdx);

            int m = positions.size();
            // 3. 核心逻辑：最近的只能是左邻居或右邻居
            // 使用 (i - 1 + m) % m 来处理首尾相连的情况
            int leftIdx = positions.get((currPosInList - 1 + m) % m);
            int rightIdx = positions.get((currPosInList + 1) % m);

            // 4. 计算环形距离
            int dist1 = calDist(targetIdx, leftIdx, n);
            int dist2 = calDist(targetIdx, rightIdx, n);

            answer.add(Math.min(dist1, dist2));
        }
        return answer;
    }

    // 计算环形距离的方法
    private int calDist(int i, int j, int n) {
        int diff = Math.abs(i - j);
        return Math.min(diff, n - diff);
    }
}
