import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {


    enum direct {
        RIGHT(0), DOWN(1), LEFT(2), UP(3);


        private int number;

        direct(int i) {
            this.number = i;
        }

        public direct getDirect(int number) {
            switch (number) {
                case 0:
                    return RIGHT;
                case 1:
                    return DOWN;
                case 2:
                    return LEFT;
                case 3:
                    return UP;
                default:
                    return RIGHT;
            }
        }

        ;

        public direct nextDirect(direct direct) {
            switch (direct) {
                case UP:
                    return RIGHT;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case RIGHT:
                    return DOWN;
                default:
                    return UP;
            }
        }

        public int[] move(direct direct, int[] position) {
            switch (direct) {
                case UP: {
                    return new int[]{position[0] - 1, position[1], 0};
                }

                case DOWN: {
                    return new int[]{position[0] + 1, position[1], 0};
                }

                case LEFT: {
                    return new int[]{position[0], position[1] - 1, 0};
                }
                case RIGHT: {
                    return new int[]{position[0], position[1] + 1, 0};
                }
                default:
                    return position;

            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        spiralOrder(test).forEach(System.out::print);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rtnList = new ArrayList<>();

        int elementCount = matrix.length * matrix[0].length;
        int c = 0;

        matrix = addWall(matrix);

        SimpleUtil.printMatrix(matrix);
        int[] position = {1, 1};

        direct dir = direct.RIGHT;
        while (c++ < elementCount) {
            rtnList.add(matrix[position[0]][position[1]]);
            matrix[position[0]][position[1]] = -200;
            if (c >= elementCount)
                break;
            position = getNextPosition(matrix, position, dir);
            dir = dir.getDirect(position[2]);

        }
        return rtnList;
    }

    private static int[] getNextPosition(int[][] matrix, int[] position, direct direct) {

        int[] np;

        do {
            np = direct.move(direct, position);
            if (matrix[np[0]][np[1]] != -200) {
                break;
            }
            direct = direct.nextDirect(direct);
        } while (true);
        np[2] = direct.ordinal();
        return np;
    }

    private static int[][] addWall(int[][] matrix) {

        int[][] rtnMatrix = new int[matrix.length + 2][matrix[0].length + 2];


        for (int i = 0; i < rtnMatrix.length; i++) {
            for (int j = 0; j < rtnMatrix[0].length; j++) {
                if (i == 0 || i == rtnMatrix.length - 1 || j == 0 || j == rtnMatrix[0].length - 1) {
                    rtnMatrix[i][j] = -200;
                } else {
                    rtnMatrix[i][j] = matrix[i - 1][j - 1];
                }
            }
        }

        return rtnMatrix;
    }
}
