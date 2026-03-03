public class finKthBit {
    public char findKthBit(int n, int k) {
        String s = getString(n);
        return s.charAt(k - 1);
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    private String getString(int n) {
        if (n == 1) {
            return "0";
        }
        String s = getString(n - 1);
        return s + "1" + invert(reverse(s));
    }
}
