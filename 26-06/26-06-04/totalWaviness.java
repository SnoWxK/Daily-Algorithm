public class totalWaviness {
    public int totalWaviness(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        if (str1.length() < 3 && str2.length() < 3) return 0;
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            String s = String.valueOf(i);
            for (int j = 1; j < s.length() - 1; j++) {
                if (s.charAt(j) > s.charAt(j - 1) && s.charAt(j) > s.charAt(j + 1)) {
                    sum++;
                }
                if (s.charAt(j) < s.charAt(j - 1) && s.charAt(j) < s.charAt(j + 1)) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
