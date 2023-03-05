import java.util.*;

public class ThreeSum_15 {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 2, -4, -1, 1};
        threeSum(nums).forEach(System.out::println);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> triplets = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++) {
                if(set.contains(-(nums[i]+nums[j]))) {
                    List<Integer> triplet = Arrays.asList(nums[i],nums[j],-(nums[i]+nums[j]));
                    Collections.sort(triplet);
                    triplets.add(triplet);
                }
            }
            set.add(nums[i]);
        }

        return new ArrayList<>(triplets);
    }
}
