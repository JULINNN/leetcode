public class CountAndSay_38 {


    public static void main(String[] args) {

        System.out.println(countAndSay(5));
    }


    public static String countAndSay(int n) {
        return countAndSay(n, new StringBuilder("1"));
    }
    public static String countAndSay(int n, StringBuilder stb) {

        if (n == 1) {
            return stb.toString();
        }

        StringBuilder nstb = new StringBuilder();

        int lastC = stb.charAt(0) - 48;
        int count = 0;
        for (int i = 0; i < stb.length(); i++) {
            if (lastC == stb.charAt(i) - 48) {
                count++;
            } else {
                nstb.append(count).append(lastC);
                count = 1;
                lastC = stb.charAt(i)-48;
            }
        }
        nstb.append(count).append("1");

        return countAndSay(n - 1, nstb);
    }
}
