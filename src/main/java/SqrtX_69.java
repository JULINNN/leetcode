public class SqrtX_69 {

    public static void main(String[] args) {

        System.out.println(mySqrt(2));
    }

    public static int mySqrt(int x) {

        return (int) binarySearch(x, 0, x);
    }

    public static long binarySearch(long target, long begin, long end) {

        while (true) {
            long mid = (begin + end) / 2;
            if (end - begin <= 1) {
                if (begin * begin == target) {
                    return begin;
                }
                if (end * end <= target)
                    return end;
                return begin;
            }

            if (mid * mid == target) {
                return mid;
            }
            if (mid * mid < target) {
                begin = mid;
            }
            if (mid * mid > target) {
                end = mid;
            }
        }
    }
}
