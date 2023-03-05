import java.util.*;

public class GrayCode_89 {

    public static void main(String[] args) {

        grayCode(3).forEach(System.out :: println);
    }

    public static List<Integer> grayCode(int n) {

        List<Integer> rtn = new ArrayList<>();

        rtn.add(0);

        Deque<String> stack = new ArrayDeque<>();

        stack.offerLast("0".repeat(n));

        while (stack.size() < Math.pow(2, n)) {
            String pre = stack.peekLast();
            if ((stack.size() & 1) == 0) {
                int changeIndex = pre.lastIndexOf("1")-1;
                char[] tmp = pre.toCharArray();
                tmp[changeIndex] = (((int)tmp[changeIndex]) & 1) == 0 ? '1' : '0';
                rtn.add(Integer.valueOf(String.valueOf(tmp),2));
                stack.add(String.valueOf(tmp));
            } else {
                int preNum = Integer.valueOf(pre, 2) & 1;
                if ((preNum) == 0) {
                    rtn.add(Integer.valueOf(pre,2) + 1);
                    stack.add(pre.substring(0,pre.length()-1)+"1");
                } else {
                    rtn.add(Integer.valueOf(pre,2) - 1);
                    stack.add(pre.substring(0,pre.length()-1)+"0");
                }
            }

        }

        return rtn;
    }
}
