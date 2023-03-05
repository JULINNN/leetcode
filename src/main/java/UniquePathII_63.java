public class UniquePathII_63 {


    public static void main(String[] args) {

        int[][] test = {{1}};

        System.out.println(uniquePathsWithObstacles(test));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid.length;
        int height = obstacleGrid[0].length;

        int[][] matrix = new int[width + 1][height + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (i == 0 || i == width + 1 || j == 0 || j == height + 1) {
                    matrix[i][j] = 0;
                }

                if (i > 0 && j > 0 && obstacleGrid[i - 1][j - 1] == 1) {
                    matrix[i][j] = Integer.MIN_VALUE;
                }

            }
        }

        SimpleUtil.printMatrix(matrix);
        if(matrix[1][1] == Integer.MIN_VALUE){
            return 0;
    }
        matrix[1][1] = 1;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == Integer.MIN_VALUE)
                    continue;
                matrix[i][j] = Math.max(matrix[i-1][j],0)+Math.max(matrix[i][j-1],0) + matrix[i][j];
            }
        }

        SimpleUtil.printMatrix(matrix);

        return Math.max(matrix[width][height],0);

    }


}
