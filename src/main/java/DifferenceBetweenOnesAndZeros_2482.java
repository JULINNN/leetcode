public class DifferenceBetweenOnesAndZeros_2482 {

  public static void main(String[] args) {}

  public static int[][] onesMinusZeros(int[][] grid) {

    int[] cols = new int[grid[0].length];
    int[] rows = new int[grid.length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        rows[i] += grid[i][j] == 1 ? 1 : -1;
        cols[j] += grid[i][j] == 1 ? 1 : -1;
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = rows[i] + cols[j];
      }
    }

    return grid;
  }
}
