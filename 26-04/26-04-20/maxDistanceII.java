public class maxDistanceII {
    public int maxDistance(int[] colors) {
        int distance = 0;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] != colors[0]) {
                distance = Math.max(distance, i);
            }
        }
        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[i] != colors[colors.length - 1]) {
                distance = Math.max(distance, colors.length - i - 1);
            }
        }
        return distance;
    }
}
