import java.util.Arrays;

public class SearchRotatedSortedArrayII_81 {


    public static void main(String[] args) {


        int[] test = {3, 5, 1};

//        System.out.println(Arrays.binarySearch(test,0,2,1));
        System.out.println(search(test, 1));
    }


    public static boolean search(int[] nums, int target) {

        int i = 1;


        while (i < nums.length - 1 && nums[i - 1] <= nums[i]) {
            if (nums[i - 1] == target) {
                return true;
            }
            i++;
        }

        int rtn = -1;
        rtn = Arrays.binarySearch(nums, i, nums.length, target);

        if (rtn >= 0)
            return true;

        rtn = Arrays.binarySearch(nums, 0, i, target);


        return rtn >= 0;
    }
}
