import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval_57 {


    public static void main(String[] args) {


        int[][] test = {{1,3},{6,9}};
        int[] ins = {2,5};
        print2DArray(insert(test,ins));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = Arrays.copyOf(intervals,intervals.length+1);

        newIntervals[intervals.length] = newInterval;

        return merge(newIntervals);
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
