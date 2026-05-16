import java.util.Arrays;

public class findMinII {
    public int findMinII(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();//我管你这那的
    }
}
