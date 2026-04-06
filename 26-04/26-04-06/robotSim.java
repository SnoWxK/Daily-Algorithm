import java.util.HashSet;
import java.util.Set;

public class robotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int x = 0, y = 0, direction = 0;

        int[] directX = new int[]{0, 1, 0, -1};
        int[] directY = new int[]{1, 0, -1, 0};

        Set<String> obstaclesSet = new HashSet<String>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        for (int com : commands) {
            if (com == -2) {
                direction = (direction + 3) % 4;
            } else if (com == -1) {
                direction = (direction + 1) % 4;
            } else {
                for (int i = 1; i <= com; i++) {
                    int newX = x + directX[direction];
                    int newY = y + directY[direction];
                    if (obstaclesSet.contains(newX + "," + newY)) {
                        break;
                    }
                    x = newX;
                    y = newY;
                    result = Math.max(result, x * x + y * y);
                }
            }
        }
        return result;
    }
}
