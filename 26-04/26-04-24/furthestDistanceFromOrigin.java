public class furthestDistanceFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int count = 0;
        int distance = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                distance--;
            } else if (moves.charAt(i) == 'R') {
                distance++;
            } else {
                count++;
            }
        }
        return Math.abs(distance) + count;
    }
}
