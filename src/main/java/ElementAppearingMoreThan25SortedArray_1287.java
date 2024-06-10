public class ElementAppearingMoreThan25SortedArray_1287 {

  public static void main(String[] args) {
    int specialInteger =
        findSpecialInteger(
            new int[] {1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 12, 12});

    System.out.println(specialInteger);
  }

  public static int findSpecialInteger(int[] arr) {
    double c = arr.length / 4.0;

    int k = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == arr[i - 1]) {
        if (++k > c) {
          return arr[i];
        }
      } else {
        k = 1;
      }
    }
    return arr[0];
  }
}
