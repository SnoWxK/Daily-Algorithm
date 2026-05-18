import java.util.*;

public class minJumpsIIII {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        int[] steps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = idxMap.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            idxMap.put(arr[i], list);
            steps[i] = arr.length - 1;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(0);
        steps[0] = 0;
        while (!queue.isEmpty()) {
            int idx = queue.pollFirst();
            if (idx == arr.length - 1)
                break;
            int nxtStep = steps[idx] + 1;
            List<Integer> list = idxMap.getOrDefault(arr[idx], new ArrayList<>());
            list.add(idx + 1);
            if (idx > 0)
                list.add(idx - 1);
            for (int other : list)
                if (steps[other] > nxtStep) {
                    steps[other] = nxtStep;
                    queue.addLast(other);
                }
            idxMap.remove(arr[idx]);
        }
        return steps[arr.length - 1];
    }
}
