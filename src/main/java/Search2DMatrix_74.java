import java.util.Arrays;

public class Search2DMatrix_74 {

    public static void main(String[] args) {
        int[][] test = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        searchMatrix(test,3);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
           int last = matrix[i].length-1;
            if(matrix[i][last] >= target && matrix[i][0] <= target){
                return Arrays.binarySearch(matrix[i], target) >= 0;
            }
        }
        return false;
    }
}
