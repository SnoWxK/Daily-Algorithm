import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class separateDigits {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[i];
            while (temp > 0) {
                list.add(temp % 10);
                temp /= 10;
            }
        }
        int[] ans = new int[list.size()];
        int idx = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans[idx++] = list.get(i);
        }
        return ans;
    }
}
