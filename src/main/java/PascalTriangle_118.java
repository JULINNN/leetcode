import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

  public static void main(String[] args) {

    generate(3);
  }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> rtn = new ArrayList<>();

    if (numRows >= 1) {
      rtn.add(List.of(1));
      if (numRows >= 2) {
        rtn.add(List.of(1, 1));
      }
    }
    for (int i = 2; i < numRows; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(1);
      for (int j = 1; j < i; j++) {
        List<Integer> list1 = rtn.get(i - 1);
        list.add(list1.get(j - 1) + list1.get(j));
      }
      list.add(1);
      rtn.add(list);
    }
    return rtn;
  }
}
