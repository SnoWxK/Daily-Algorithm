public class numberOfSpecialCharsII {
    public int numberOfSpecialChars(String word) {
        int[] vis1 = new int[26];
        int[] vis2 = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                vis1[word.charAt(i) - 'a'] = i + 1;
            }
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                vis2[word.charAt(i) - 'A'] = i + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (vis1[i] < vis2[i] && vis1[i] != 0 && vis2[i] != 0) {
                ans++;
            }
        }
        return ans;
    }
}
