import java.util.ArrayList;
import java.util.List;

public class Fancy {
    List<Long> list;
    long mod = 1000000007;
    private long mul = 1;
    private long add = 0;

    public Fancy() {
        list = new ArrayList<>();
    }

    private long power(long a, long b) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    private long modInverse(long n) {
        return power(n, mod - 2);
    }

    public void append(int val) {
        long inv = modInverse(mul);
        long original = (val - add + mod) % mod;
        list.add((original * inv) % mod);
    }

    public void addAll(int inc) {
        add = (add + inc) % mod;
    }

    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }

    public int getIndex(int index) {
        if (index >= list.size()) return -1;
        long res = (list.get(index) * mul + add) % mod;
        res = (res + mod) % mod;
        return (int) res;
    }
}
