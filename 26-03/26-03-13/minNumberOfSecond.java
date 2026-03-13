public class minNumberOfSecond {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        long minWorkerTime = workerTimes[0];
        for (int w : workerTimes) {
            minWorkerTime = Math.min(minWorkerTime, w);
        }
        long high = minWorkerTime * mountainHeight * (mountainHeight + 1L) / 2;

        long ans = high;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean check(long limitTime, int targetHeight, int[] workerTimes) {
        long totalLowered = 0;
        for (int w : workerTimes) {
            long x = (long) ((-1 + Math.sqrt(1 + 8.0 * limitTime / w)) / 2);
            totalLowered += x;

            if (totalLowered >= targetHeight) {
                return true;
            }
        }
        return totalLowered >= targetHeight;
    }
}
