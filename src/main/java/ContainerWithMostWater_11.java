import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainerWithMostWater_11 {


    public static void main(String[] args) {

        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(test));
    }


    public static int maxArea(int[] height) {

        int rs = 0;

        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = height.length - 1; j > 0; j--) {
                int right = height[j];
                if (right >= left) {
                    rs = Math.max(rs, left * (j - i));
                    break;
                }
            }
        }

        for (int j = height.length - 1; j > 0; j--) {
            int right = height[j];
            for (int i = 0; i < height.length; i++) {
                int left = height[i];
                if (right <= left) {
                    rs = Math.max(rs, right * (j - i));
                    break;
                }
            }
        }

        return rs;
    }
}
