public class SignOfTheProductOfAnArray_1822 {

    public static void main(String[] args) {
        System.out.println(arraySign(new int[]{-1, 1, -1, 1, -1}));
    }

    public static int arraySign(int[] nums) {
        int rtn = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                rtn *= -1;
            } else if (nums[i] == 0) {
                return 0;
            }
        }
        return rtn;
    }
}
