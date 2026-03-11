public class bitwiseComplement {
    public int bitwiseComplement(int n) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(n));
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                binary.setCharAt(i, '0');
            } else {
                binary.setCharAt(i, '1');
            }
        }
        return Integer.parseInt(binary.toString(), 2);
    }
}
