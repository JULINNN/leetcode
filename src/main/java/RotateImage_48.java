public class RotateImage_48 {


    public static void main(String[] args) {
        int[][] test = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        rotate(test);

        for (int[] ints : test) {
            for (int anInt : ints) {
                System.out.print(
                        anInt + " "
                );
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length-1 - i; j++) {
                rotate(matrix, i, j);
            }
        }
    }

    /**
     * 0 0 ===> 0 2
     */
    public static void rotate(int[][] matrix, int i, int j) {

        int curI = i;
        int curJ = j;

        int rotateI = j;
        int rotateJ = matrix.length - 1 - i;

        int c = 0;
        int tmp = matrix[curI][curJ];
        int nextTmp = matrix[rotateI][rotateJ];
        while (c++ < 4) {
            matrix[rotateI][rotateJ] = tmp;
            curI = rotateI;
            curJ = rotateJ;

            rotateI = curJ;
            rotateJ = matrix.length - 1 - curI;
            tmp = nextTmp;
            nextTmp = matrix[rotateI][rotateJ];
        }
    }
}
