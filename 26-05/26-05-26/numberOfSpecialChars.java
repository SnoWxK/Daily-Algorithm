public class numberOfSpecialChars {
    public int numberOfSpecialChars(String word) {
        int res = 0;
        int[] count = new int[26];
        int[] count2 = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                count2[c - 'A']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 1 && count2[i] >= 1) res++;
        }
        return res;
    }
}
