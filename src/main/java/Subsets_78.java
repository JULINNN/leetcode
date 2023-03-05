import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        subsets(test);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, 0, rtn, new ArrayList<>(), i);
        }

        return rtn;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> tmp, int size) {
        if (tmp.size() == size) {
            result.add(new ArrayList<>(tmp));
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
