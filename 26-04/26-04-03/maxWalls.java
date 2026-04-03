import java.util.Arrays;

public class maxWalls {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[][] robotsDistances = new int[n][];
        for (int i = 0; i < n; i++) {
            robotsDistances[i] = new int[]{robots[i], distance[i]};
        }
        Arrays.sort(robotsDistances, (a, b) -> a[0] - b[0]);
        Arrays.sort(walls);
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int currRobot = robotsDistances[i - 1][0], currDistance = robotsDistances[i - 1][1];
            int leftRobot = i > 1 ? robotsDistances[i - 2][0] : Integer.MIN_VALUE;
            int leftRobotRight = i > 1 ? Math.min(robotsDistances[i - 2][0] + robotsDistances[i - 2][1], currRobot - 1) : Integer.MIN_VALUE;
            int leftBound0 = Math.max(currRobot - currDistance, leftRobot + 1);
            int leftBound1 = Math.max(currRobot - currDistance, leftRobotRight + 1);
            int leftBoundIndex0 = binarySearchCeiling(walls, leftBound0);
            int leftBoundIndex1 = binarySearchCeiling(walls, leftBound1);
            int leftMaxIndex = binarySearchFloor(walls, currRobot);
            int rightRobot = i < n ? robotsDistances[i][0] : Integer.MAX_VALUE;
            int rightBound = Math.min(currRobot + currDistance, rightRobot - 1);
            int rightBoundIndex = binarySearchFloor(walls, rightBound);
            int rightMinIndex = binarySearchCeiling(walls, currRobot);
            dp[i][0] = Math.max(dp[i - 1][0] + leftMaxIndex - leftBoundIndex0 + 1, dp[i - 1][1] + leftMaxIndex - leftBoundIndex1 + 1);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + rightBoundIndex - rightMinIndex + 1;
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public int binarySearchCeiling(int[] walls, int target) {
        int low = 0, high = walls.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (walls[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int binarySearchFloor(int[] walls, int target) {
        int low = -1, high = walls.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (walls[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
