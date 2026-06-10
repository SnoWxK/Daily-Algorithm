import java.util.PriorityQueue;

public class maxTotalValueII {
    int[] minArr;
    int[] maxArr;
    PriorityQueue<int[]> pq;

    public long maxTotalValue(int[] nums, int k) {
        int len = nums.length;
        minArr = new int[len * 4 + 1];
        maxArr = new int[len * 4 + 1];
        pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        buildTree(nums, 1, 0, len - 1);
        for (int i = 0; i < len; i++) {
            int[] arr = new int[3];
            arr[0] = i;
            arr[1] = len - 1;
            arr[2] = queryMax(nums, 1, 0, len - 1, arr[0], arr[1]) - queryMin(nums, 1, 0, len - 1, arr[0], arr[1]);
            pq.offer(arr);
        }
        long ans = 0;
        while (k > 0) {
            int[] arr = pq.poll();
            ans += arr[2];
            if (arr[0] + 1 <= arr[1]) {
                arr[1]--;
                arr[2] = queryMax(nums, 1, 0, len - 1, arr[0], arr[1]) - queryMin(nums, 1, 0, len - 1, arr[0], arr[1]);
                pq.offer(arr);
            }
            k--;
        }
        return ans;
    }

    private void buildTree(int[] nums, int pos, int left, int right) {
        if (left == right) {
            minArr[pos] = nums[left];
            maxArr[pos] = nums[left];
            return;
        }
        int mid = (left + right) / 2;
        buildTree(nums, pos * 2, left, mid);
        buildTree(nums, pos * 2 + 1, mid + 1, right);
        minArr[pos] = Math.min(minArr[pos * 2], minArr[pos * 2 + 1]);
        maxArr[pos] = Math.max(maxArr[pos * 2], maxArr[pos * 2 + 1]);
    }

    private int queryMax(int[] nums, int pos, int left, int right, int low, int high) {
        if (left > high || right < low)
            return -1;
        if (left >= low && right <= high)
            return maxArr[pos];
        int mid = (left + right) / 2;
        int leftRes = queryMax(nums, pos * 2, left, mid, low, high);
        int rightRes = queryMax(nums, pos * 2 + 1, mid + 1, right, low, high);
        if (leftRes == -1)
            return rightRes;
        else if (rightRes == -1)
            return leftRes;
        else
            return Math.max(leftRes, rightRes);
    }

    private int queryMin(int[] nums, int pos, int left, int right, int low, int high) {
        if (left > high || right < low)
            return -1;
        if (left >= low && right <= high)
            return minArr[pos];
        int mid = (left + right) / 2;
        int leftRes = queryMin(nums, pos * 2, left, mid, low, high);
        int rightRes = queryMin(nums, pos * 2 + 1, mid + 1, right, low, high);
        if (leftRes == -1)
            return rightRes;
        else if (rightRes == -1)
            return leftRes;
        else
            return Math.min(leftRes, rightRes);
    }
}
