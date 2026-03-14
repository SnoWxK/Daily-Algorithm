import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getHappyString {
    List<String> list = new ArrayList<>();
    char [] ch = new char[]{'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        if (k > 3 * Math.pow(2, n - 1)) {
            return "";
        }
        backTrack(n, new StringBuilder());
        Arrays.sort(list.toArray());
        return list.get(k-1);
    }

    private void backTrack(int n,StringBuilder sb){
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for(char c:ch){
            if (sb.length() > 0 && c == sb.charAt(sb.length() - 1)) {
                continue;
            }
            sb.append(c);
            backTrack(n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
