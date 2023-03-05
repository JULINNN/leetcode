import java.util.Arrays;

public class FindFirstLastPositionInSortedArray_34 {


    public static void main(String[] args) {

    }


    public static int[] searchRange(int[] nums, int target) {

        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }

        int i = index;
        int j = index;

        while (i < nums.length-1 && nums[i+1] == target) {
            i++;
        }

        while (j > 0 && nums[j-1] == target) {
            j--;
        }

        return new int[]{j, i};
    }
}
