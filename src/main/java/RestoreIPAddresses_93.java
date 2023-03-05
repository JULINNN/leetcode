import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.Deflater;

public class RestoreIPAddresses_93 {

    public static void main(String[] args) {
        String test = "abc";

        StringBuilder stb = new StringBuilder(test);

        stb.insert(1, "d");

        restoreIpAddresses("1231231231234");
//        System.out.println(stb);
    }

    public static List<String> restoreIpAddresses(String s) {

        if (s.length() > 12) {
            return Collections.emptyList();
        }

        List<String> rtn = new ArrayList<>();
        StringBuilder stb = new StringBuilder(s);
        for (int i = 1; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                for (int k = j + 1; k < s.length(); k++) {
                    stb = stb.insert(i, ".").insert(j + 1, ".").insert(k + 2, ".");
                    if (!Stream.of(stb.toString().split("\\.")).anyMatch(str -> (str.startsWith("0") && str.length() > 1) || Double.parseDouble(str) > 255))
                        rtn.add(stb.toString());
                    stb = stb.deleteCharAt(k + 2).deleteCharAt(j + 1).deleteCharAt(i);
                }

            }
        }

        return rtn;
    }
}
