public class closestTarget {
    public int closestTarget(String[] words, String target, int startIndex) {
        int cost = -1;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[(startIndex + i) % n].equals(target)) {
                cost = i;
                return cost;
            }
            if (words[(startIndex - i + n) % n].equals(target)) {
                cost = i;
                return cost;
            }
        }
        return cost;
    }
}
