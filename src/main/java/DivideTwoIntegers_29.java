public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        long rs = ((long)dividend / (long)divisor);
        if(rs > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(rs < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)rs;
    }
}
