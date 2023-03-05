import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class SearchRotatedSortedArray_33 {


    public static void main(String[] args) {


        int[] test = {3,5,1};

//        System.out.println(Arrays.binarySearch(test,0,2,1));
        System.out.println(search(test, 1));
    }


    public static int search(int[] nums, int target) {


        // 6 7 8 9 10 1 2 3 4 5
        int i = 1;


        while (i < nums.length - 1  && nums[i - 1] < nums[i]) {
            if(nums[i-1] == target){
                return i - 1;
            }
            i++;
        }

        int rtn = -1;
        rtn = Arrays.binarySearch(nums, i, nums.length, target);

        if(rtn >= 0)
            return rtn;

        rtn = Arrays.binarySearch(nums, 0, i, target);


        return rtn >= 0 ? rtn : -1;
    }
}
