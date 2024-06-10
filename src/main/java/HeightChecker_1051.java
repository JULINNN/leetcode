import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HeightChecker_1051 {

  public static void main(String[] args) {}

  public int heightChecker(int[] heights) {

    List<Integer> sortedList = Arrays.stream(heights).boxed().sorted().collect(Collectors.toList());

    int rtn = 0;
    for (int i = 0; i < heights.length; i++) {
      if (sortedList.get(i) != heights[i]) {
        rtn++;
      }
    }
    return rtn;
  }
}
