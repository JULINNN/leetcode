
import java.util.*;


/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * <p>
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * <p>
 * -2 -1 0 0 1 2
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * https://leetcode.com/problems/4sum/
 */
public class FourSum_18 {


    public static void main(String[] args) {
        int[] test = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};


         int[] test2 = {1, 0, -1, 0, -2, 2};

        // -5 -4 -3 -2 1 3 3 5
        new FourSum_18().fourSum(test2, 0).forEach(System.out::println);

    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return new ArrayList();
        Arrays.sort(nums);
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add((long) nums[i]);
        }
        List<List<Integer>> rtnList = new ArrayList<>();
        this.dfs(0, target, 0, nums, new ArrayList<>(), rtnList,set);
        return rtnList;

    }

    private void dfs(int index, long diff, int max, int[] nums, List<Integer> tmp, List<List<Integer>> rtnList,Set<Long> set) {
        if (diff == 0 && tmp.size() == 4) {
            if (!rtnList.contains(tmp)) {
                rtnList.add(new ArrayList<>(tmp));
            }
            return;
        }

        if (tmp.size() == 3 && (nums[max] > diff || !set.contains(diff)))
            return;

        for (int i = index; i < nums.length; i++) {
            if (tmp.size() < 4 && i >= max) {
                tmp.add(nums[i]);
                dfs(index + 1, diff - nums[i], max, nums, tmp, rtnList,set);
                tmp.remove(Integer.valueOf(nums[i]));
                index = i + 1;
                max = tmp.size() != 3 ? index : getMax((int) diff, nums, tmp, i);
            }
        }
    }

    private int getMax(int diff, int[] nums, List<Integer> tmp, int i) {
        int max = Arrays.binarySearch(nums, i, nums.length-1, diff);
        for (int j = max; j < nums.length - 1; j++) {
            if (max < 0 || nums[j] != nums[j + 1])
                break;
            max++;
        }
        return max;
    }
}
