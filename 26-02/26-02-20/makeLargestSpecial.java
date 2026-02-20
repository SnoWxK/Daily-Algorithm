import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class makeLargestSpecial {

    public String makeLargestSpecial(String s) {
        // 递归边界
        if (s.length() == 0) {
            return "";
        }

        // 存储当前层级拆分出的所有特殊子串
        List<String> substrings = new ArrayList<>();

        int count = 0;  // 计数，遇到1就+1，遇到0就-1
        int start = 0;  // 当前子串的起始索引

        // 枚举拆分位置
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '1') ? 1 : -1;

            // 此时，找到了一个完整的特殊子串
            if (count == 0) {
                // 当前子串必定是 "1" + "内部" + "0" 的形式
                String inner = s.substring(start + 1, i);
                // 递归处理中间，让中间字典序最大
                String optimizedInner = makeLargestSpecial(inner);
                // 重新包上 1 和 0
                substrings.add("1" + optimizedInner + "0");
                // 下一个子串的起始位置
                start = i + 1;
            }
        }

        // 所有子串按字典序降序排列
        Collections.sort(substrings, Collections.reverseOrder());
        // 合并
        return String.join("", substrings);
    }
}
