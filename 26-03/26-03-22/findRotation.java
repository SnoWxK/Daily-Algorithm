import java.util.Arrays;

public class findRotation {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int k = 0; k < 4; k++) {
            int[][] temp = new int[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    temp[i][j] = mat[mat.length - 1 - j][i];
                }
            }
            if (Arrays.deepEquals(temp, target)) {
                return true;
            }
            mat = temp;
        }
        return false;
    }
}
