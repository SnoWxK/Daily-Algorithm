public class processStr {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!result.isEmpty()) result.deleteCharAt(result.length() - 1);
            } else if (ch == '#') {
                result.append(result.toString());
            } else if (ch == '%') {
                result.reverse();
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
