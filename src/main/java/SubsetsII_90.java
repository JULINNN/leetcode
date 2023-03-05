import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII_90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, rtn, new ArrayList<>(), i);
        }

        return rtn;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> tmp, int size) {
        if (tmp.size() == size) {
            Collections.sort(tmp);
            if (!result.contains(tmp)) {
                result.add(new ArrayList<>(tmp));
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (tmp.size() < size) {
                tmp.add(nums[i]);
                dfs(nums, i + 1, result, tmp, size);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
