import java.util.HashSet;

public class longestCommonPrefix {
    public int longestCommonPrefix(int[] arr1,int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for (int j : arr1) {
            int temp = j;
            while (temp > 0) {
                set.add(temp);
                temp /= 10;
            }
        }
        int ans = 0;
        for (int j : arr2) {
            int temp = j;
            while (temp > 0) {
                if (set.contains(temp) && String.valueOf(temp).length() > ans) {
                    ans = String.valueOf(temp).length();
                }
                temp /= 10;
            }
        }
        return ans;
    }
}
