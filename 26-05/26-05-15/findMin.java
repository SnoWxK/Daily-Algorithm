import java.util.Arrays;

public class findMin {
    public int findMin(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();//我管你这那的
    }
}
