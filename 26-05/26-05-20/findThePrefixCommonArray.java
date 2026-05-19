import java.util.HashSet;

public class findThePrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] rs = new int[len];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (A[0] == B[0]) {
                    rs[0] = 1;
                } else {
                    rs[0] = 0;
                }
            } else {
                rs[i] = rs[i - 1];
                if (A[i] == B[i]) {
                    rs[i] += 1;
                } else {
                    if (setA.contains(B[i])) {
                        rs[i] += 1;
                    }
                    if (setB.contains(A[i])) {
                        rs[i] += 1;
                    }
                }
            }
            setA.add(A[i]);
            setB.add(B[i]);
        }
        return rs;
    }
}
