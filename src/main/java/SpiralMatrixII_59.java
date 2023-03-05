public class SpiralMatrixII_59 {


    public static void main(String[] args) {


        print2DArray(generateMatrix(4));
    }

    public static int[][] generateMatrix(int n) {

        if (n == 1) {
            return new int[][]{{1}};
        }

        int[][] matrix = new int[n][n];

        int count = 0;
        int max = n * n;
        int[] position = {0, 0, 0};
        while (true) {
            matrix[position[0]][position[1]] = ++count;
            if(count == max){
                break;
            }
            position = getNextPosition(matrix, n, position);
        }

        return matrix;
    }

    private static int[] getNextPosition(int[][] matrix, int n, int[] position) {
        int i = position[0];
        int j = position[1];
        int tmpI = i;
        int tmpJ = j;

        int direct = position[2]; // 0 -> 右 , 1-> 下 ,2-> 左  3 -> 上
        while (true) {

            switch (direct) {
                case 0:
                    tmpJ = tmpJ + 1;
                    break;
                case 1:
                    tmpI = tmpI + 1;
                    break;
                case 2:
                    tmpJ = tmpJ - 1;
                    break;
                case 3:
                    tmpI = tmpI - 1;
                    break;
            }

            if (tmpI >= 0 && tmpI < n && tmpJ >= 0 && tmpJ < n && matrix[tmpI][tmpJ] == 0) {
                break;
            }

            tmpI = i;
            tmpJ = j;

            direct = (direct + 1) % 4;
        }

        return new int[]{tmpI, tmpJ, direct};
    }

    private static void print2DArray(int[][] intervals) {
        for (int[] interval : intervals) {
            for (int i : interval) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
