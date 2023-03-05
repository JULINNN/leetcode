import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortColors_75 {

    public static void main(String[] args) {

        sortColors(new int[]{2,0,2,1,1,0});
    }

    public static void sortColors(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.computeIfPresent(num, (k, v) -> v + 1);
        }

        int c1 = map.getOrDefault(0,0);
        int c2 = c1 + map.getOrDefault(1,0);
        int c3 = c2 + map.getOrDefault(2,0);
        forloop(nums,0,c1,0);
        forloop(nums,c1,c2,1);
        forloop(nums,c2,c3,2);
    }

    public static void forloop(int[] nums, int start, int end,int val) {
        for (int i = start; i < end && i < nums.length; i++) {
            nums[i] =val;
        }
    }
}
