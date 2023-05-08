public class MatrixDiagonalSum_1572 {

    public static void main(String[] args) {

    }

    public int diagonalSum(int[][] mat) {
        int result = 0;

        int i = 0;
        int j = 0;

        int c = mat.length;
        while (c-- > 0) {
            if (mat.length - 1 - i != j) {
                result += mat[mat.length - 1 - i][j];
            }
            result += mat[i][j];
            i++;
            j++;
        }
        return result;
    }


}
