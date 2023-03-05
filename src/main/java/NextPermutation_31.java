public class NextPermutation_31 {


    /**
     * 因為要找下一個較大的排列所以由後往前找
     * 找出從又到左第一個下降的數字
     * <p>
     * 找出這個數字後後找出比這個數字小的前一個數字來做交換
     * <p>
     * 右半在全部翻轉
     * <p>
     * 3 2 1   ===> 如果是最大則全部翻轉過來
     * <p>
     * 1 8 7 6 5 2 3 4 5 6 5 5 3 2
     */

    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        nextPermutation(test);

        for (int i : test) {
            System.out.println(i);
        }
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
