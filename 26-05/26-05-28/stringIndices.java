public class stringIndices {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieIndices trie = new TrieIndices();
        for (int i = 0; i < wordsContainer.length; i++) {
            trie.add(wordsContainer[i], i);
        }
        int length = wordsQuery.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = trie.find(wordsQuery[i]);
        }
        return ans;
    }

    private static class TrieIndices {

        TrieIndices[] chars = new TrieIndices[26];

        int bestLen = Integer.MAX_VALUE;

        int bestIndex = Integer.MAX_VALUE;

        public void add(String word, int index) {
            TrieIndices trie = this;
            int len = word.length();
            if (len < trie.bestLen || (len == trie.bestLen && index < trie.bestIndex)) {
                trie.bestLen = len;
                trie.bestIndex = index;
            }
            for (int i = len - 1; i >= 0; i--) {
                int charIndex = word.charAt(i) - 'a';
                if (trie.chars[charIndex] == null) {
                    trie.chars[charIndex] = new TrieIndices();
                }
                trie = trie.chars[charIndex];
                // 判断word是否此节点的最优字符串
                if (len < trie.bestLen || (len == trie.bestLen && index < trie.bestIndex)) {
                    trie.bestLen = len;
                    trie.bestIndex = index;
                }
            }
        }

        public int find(String word) {
            TrieIndices trie = this;
            int len = word.length();
            for (int i = len - 1; i >= 0; i--) {
                int charIndex = word.charAt(i) - 'a';
                if (trie.chars[charIndex] == null) {
                    break;
                } else {
                    trie = trie.chars[charIndex];
                }
            }
            return trie.bestIndex;
        }

    }
//
//    作者：canhui
//    链接：https://leetcode.cn/problems/longest-common-suffix-queries/solutions/2704935/qian-zhui-shu-jie-fa-by-canhui-o73j/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
