public class mapWordWeights {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (char ch : words[i].toCharArray()) {
                sum += weights[ch - 'a'];
            }
            ans[i] = (char) ('z' - sum % 26);
        }
        return new String(ans);
    }
}
