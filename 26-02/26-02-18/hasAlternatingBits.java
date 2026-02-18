public class hasAlternatingBits {
    public static void main(String[] args) {
        System.out.println(new hasAlternatingBits().hasAlternatingBits(6));
    }
    public boolean hasAlternatingBits(int n) {
        String num = Integer.toBinaryString(n);
        boolean flag = true;
        for (int i = 0; i < num.length()-1; i++) {
            flag = num.charAt(i) != num.charAt(i + 1);
            if (!flag) {
                return false;
            }
        }
        return flag;
    }
}
