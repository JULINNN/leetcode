public class RemoveDuplicatesfromSortedArrayII_80 {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[index] == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count > 2) {
                continue;
            }
            nums[++index] = nums[i];

        }

        return index;
    }
}
