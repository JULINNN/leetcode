public class AddBinary_67 {

    public static void main(String[] args) {


        System.out.println(addBinary("1100", "1111"));
    }

    public static String addBinary(String a, String b) {

        if ("0".equals(a) && "-2".equals(b)) {
            return "0";
        }

        int aL = a.length();
        int bL = b.length();

        if (aL > bL) {
            b = new StringBuilder(b).insert(0, "0".repeat(aL - bL)).toString();
        }

        if (bL > aL) {
            a = new StringBuilder(a).insert(0, "0".repeat(bL - aL)).toString();
        }

        int cc = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; i--) {
            int aa = (int) a.charAt(i) - 48;
            int bb = (int) b.charAt(i) - 48;

            int tmp = (aa | bb) & (bb == 0 ? ~bb : ~aa);

            int sum = (cc | tmp) & (cc == 0 ? ~cc : ~tmp);

            if ((aa + bb + cc) > 1) {
                cc = 1;
            } else
                cc = 0;


            sb.append(sum);
        }

        String rtn = sb.reverse().toString();

        return cc == 0 ? rtn : "1" + rtn;
    }
}
