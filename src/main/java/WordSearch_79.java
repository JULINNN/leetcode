import java.util.ArrayList;
import java.util.List;

public class WordSearch_79 {

    public static void main(String[] args) {

        char[][] test = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};

        System.out.println(exist(test, "ABCEFSADEESE"));
    }

    public static boolean exist(char[][] board, String word) {

        char[] target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == target[0]) {
                    List<Boolean> flag = new ArrayList<>();
                    backtracking(board, target, new boolean[board.length][board[0].length], i, j, 1, flag);

                    if (!flag.isEmpty())
                        return true;
                }
            }
        }
        return false;
    }

    public static void backtracking(char[][] board, char[] target, boolean[][] isVisit, int i, int j, int index, List<Boolean> rs) {
        if (target.length == index) {
            rs.add(true);
            return;
        }

        isVisit[i][j] = true;

        List<int[]> nextPoints = new ArrayList<>();


        if (j + 1 < board[0].length && board[i][j + 1] == target[index] && !isVisit[i][j + 1]) {
            nextPoints.add(new int[]{i, j + 1});
        }
        if (i + 1 < board.length && board[i + 1][j] == target[index] && !isVisit[i + 1][j]) {
            nextPoints.add(new int[]{i + 1, j});
        }

        if (j >= 1 && board[i][j - 1] == target[index] && !isVisit[i][j - 1]) {
            nextPoints.add(new int[]{i, j - 1});
        }
        if (i >= 1 && board[i - 1][j] == target[index] && !isVisit[i - 1][j]) {
            nextPoints.add(new int[]{i - 1, j});
        }

        for (int[] nextPoint : nextPoints) {
            backtracking(board, target, isVisit, nextPoint[0], nextPoint[1], index + 1, rs);
            isVisit[nextPoint[0]][nextPoint[1]] = false;
        }
    }

}
