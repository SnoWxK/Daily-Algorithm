import java.util.Arrays;
import java.util.stream.IntStream;

public class asteroidsDestroyed {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currentMass = mass;
        for (int m : asteroids) {
            if (currentMass < m) {
                return false;
            }
            currentMass += m;
        }
        return true;
    }
}
