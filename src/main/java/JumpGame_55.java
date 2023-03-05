public class JumpGame_55 {

    public static boolean canJump(int[] nums) {

        int index = 0;
        while (index < nums.length - 1) {
            index = getNext(nums, index);
            if (nums[index] == 0 && index != nums.length - 1) {
                return false;
            }
        }
        return true;

    }

    private static int getNext(int[] nums, int index) {
        int rs = index;
        for (int i = index + 1; i <= index + nums[index]; i++) {
            if (i == nums.length - 1) {
                return nums.length - 1;
            }
            if (nums[rs] + rs <= nums[i] + i) {
                rs = i;
            }
        }
        return rs;
    }
}
