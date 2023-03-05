public class JumpGameII_45 {


    public static void main(String[] args) {

        int[] test = {2, 3, 1};
        System.out.println(jump(test));
    }

    //  x   x x x x x x x         x x
    // [2,1,1,1,1,1,2,3,5,2,2,1,1,1,11,1,1,1]
    public static int jump(int[] nums) {

        int count = 0;
        int index = 0;
        while (index < nums.length - 1) {
            index = getNext(nums, index);
            count++;
        }

        return count;

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
