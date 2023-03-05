import java.util.Arrays;

public class ValidSudoku_36 {


    public static void main(String[] args) {


//        isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        int[] vaildRow = new int[9];
        int[] vaildCol = new int[9];
        int[][] vaildSubCube = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value1 = board[i][j] - 49;
                if (value1 >= 0) {
                    boolean isVaild = vaildRow[value1]++ == 0;
                    if (!isVaild) {
                        return false;
                    }
                }
                int value2 = board[j][i] - 49;
                if (value2 >= 0) {
                    boolean isVaild = vaildCol[value2]++ == 0;
                    if (!isVaild) {
                        return false;
                    }
                }

                int value3 = board[i][j] - 49;
                if(value3 >=0){
                    boolean isVaild = vaildSubCube[getPosition(i,j)][value3]++==0;
                    if(!isVaild){
                        return false;
                    }
                }
            }
            Arrays.fill(vaildCol, 0);
            Arrays.fill(vaildRow, 0);
        }

        return true;
    }

    private int getPosition(int i, int j) {
        int a = i / 3;
        int b = j / 3;
        return a*3+b;
    }
}
