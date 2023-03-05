import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {

    public static void main(String[] args) {

        int[][] test = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        ;
        print2DArray(merge(test));
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                intervals[index][1] = Math.max(intervals[i][1], intervals[index][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
            } else if (intervals[i][0] != -1) {
                index = i;
            }
        }


        List<int[]> computeList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                computeList.add(interval);
            }
        }
        return computeList.toArray(new int[1][1]);
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
