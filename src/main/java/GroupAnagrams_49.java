import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams_49 {


    public static void main(String[] args) {
        groupAnagrams(new String[]{"bdsak","ddih"});
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> computeMap = new HashMap<>();

        for (String str : strs) {
            String key = str.chars().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());
            computeMap.putIfAbsent(key, new ArrayList<>());
            computeMap.computeIfPresent(key, (k, v) -> {
                v.add(str);
                return v;
            });
        }

        return new ArrayList<>(computeMap.values());
    }
}
