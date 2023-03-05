import java.util.*;
import java.util.stream.Collectors;

public class PhoneNumber_17 {


//    ["www","wwx","wwy","wwz","wxw","xwx","wxy","wxz","wyw","ywx","ywy","wyz","wzw","zwx","zwy","zwz","xww","xwx","wxy","wxz","xxw","xxx","xxy","xxz","xyw","xyx","yxy","xyz","xzw","xzx","zxy","zxz","yww","ywx","ywy","wyz","yxw","yxx","yxy","xyz","yyw","yyx","yyy","yyz","yzw","yzx","yzy","zyz","zww","zwx","zwy","zwz","zxw","zxx","zxy","zxz","zyw","zyx","zyy","zyz","zzw","zzx","zzy","zzz"]
//    ["www","wwx","wwy","wwz","wxw","wxx","wxy","wxz","wyw","wyx","wyy","wyz","wzw","wzx","wzy","wzz","xww","xwx","xwy","xwz","xxw","xxx","xxy","xxz","xyw","xyx","xyy","xyz","xzw","xzx","xzy","xzz","yww","ywx","ywy","ywz","yxw","yxx","yxy","yxz","yyw","yyx","yyy","yyz","yzw","yzx","yzy","yzz","zww","zwx","zwy","zwz","zxw","zxx","zxy","zxz","zyw","zyx","zyy","zyz","zzw","zzx","zzy","zzz"]

    static Map<String, String[]> map = new HashMap<>();


    static {
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});
    }

    public static void main(String[] args) {

        letterCombinations("999").forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return new ArrayList<>();

        String[] numbers = digits.split("");

        List<String> result = new ArrayList<>();

        List<String[]> strs = new ArrayList<>();

        for (String number : numbers) {
            strs.add(map.get(number));
        }

        dfs(strs, new StringBuilder(), result, 0, digits.length());

        return result;
    }


    public static void dfs(List<String[]> strs, StringBuilder tmp, List<String> result, int index, int length) {

        if (tmp.length() == length) {
            result.add(tmp.toString());
            return;
        }

        for (int i = index; i < strs.size(); i++) {
            String[] strings = strs.get(i);
            for (int j = 0; j < strings.length; j++) {
                if (tmp.length() < length) {
                    tmp.append(strings[j]);
                    dfs(strs, tmp, result, i + 1, length);
                    tmp.deleteCharAt(tmp.length() - 1);
                }
            }
        }
    }

}
