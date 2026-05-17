import java.util.LinkedList;
import java.util.Queue;

public class canReach {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            if(arr[cur] == 0) return true;
            if(cur+arr[cur] < n) queue.offer(cur+arr[cur]);
            if(cur-arr[cur] >= 0) queue.offer(cur-arr[cur]);
        }
        return false;
    }
}
