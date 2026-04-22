import java.util.ArrayList;
import java.util.List;

public class twoEditWords {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for (String q : queries) {
            for (String s : dictionary) {
                int count = 0;
                for (int i = 0; i < s.length() && count <= 2; i++) {
                    if (q.charAt(i) != s.charAt(i)) {
                        count++;
                    }
                }
                if (count <= 2) {
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }
}
