import java.math.BigInteger;

public class numSteps {
    public int numSteps(String s){
        BigInteger num = new BigInteger(s, 2);
        int count = 0;
        while (!num.equals(BigInteger.ONE)) {
            if (num.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.valueOf(2));
            } else {
                num = num.add(BigInteger.ONE);
            }
            count++;
        }
        return count;

    }
}
