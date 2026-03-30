import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class checkStrings {
    public boolean checkStrings(String s1, String s2) {
        List<Character> odds1 = new ArrayList<>();
        List<Character> evens1 = new ArrayList<>();
        List<Character> odds2 = new ArrayList<>();
        List<Character> evens2 = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evens1.add(s1.charAt(i));
            } else {
                odds1.add(s1.charAt(i));
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                evens2.add(s2.charAt(i));
            } else {
                odds2.add(s2.charAt(i));
            }
        }

        Collections.sort(odds1);
        Collections.sort(evens1);
        Collections.sort(odds2);
        Collections.sort(evens2);
        return odds1.equals(odds2) && evens1.equals(evens2);
    }
}
