import java.util.*;

public class minJumps {
    static final int MAX_NUM = 1000000;
    static List<Integer>[] primeFactors = new List[MAX_NUM + 1];

    static {
        for (int i = 0; i <= MAX_NUM; i++) {
            primeFactors[i] = new ArrayList<Integer>();
        }
        for (int i = 2; i <= MAX_NUM; i++) {
            if (primeFactors[i].isEmpty()) {
                for (int j = i; j <= MAX_NUM; j += i) {
                    primeFactors[j].add(i);
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> primeTeleportations = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            List<Integer> currPrimeFactors = primeFactors[nums[i]];
            for (int prime : currPrimeFactors) {
                primeTeleportations.putIfAbsent(prime, new ArrayList<Integer>());
                primeTeleportations.get(prime).add(i);
            }
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(0);
        int jumps = -1;
        int endJumps = -1;
        while (!queue.isEmpty() && endJumps < 0) {
            jumps++;
            int size = queue.size();
            for (int i = 0; i < size && endJumps < 0; i++) {
                int index = queue.poll();
                if (index == n - 1) {
                    endJumps = jumps;
                } else {
                    if (index > 0 && !visited[index - 1]) {
                        visited[index - 1] = true;
                        queue.offer(index - 1);
                    }
                    if (index < n - 1 && !visited[index + 1]) {
                        visited[index + 1] = true;
                        queue.offer(index + 1);
                    }
                    List<Integer> teleportations = primeTeleportations.getOrDefault(nums[index], new ArrayList<Integer>());
                    for (int next : teleportations) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                    primeTeleportations.remove(nums[index]);
                }
            }
        }
        return endJumps;
    }
}
