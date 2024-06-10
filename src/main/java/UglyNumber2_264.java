public class UglyNumber2_264 {

  public static void main(String[] args) {

    //    int i = nthUglyNumber(5);
    System.out.println(nthUglyNumber(10 ));
  }

  public static int nthUglyNumber(int n) {

    double[] index = new double[n];
    index[0] = 1;
    for (int i = 1; i < n; i++) {
      double next = Integer.MAX_VALUE;
      for (int j = Math.max(0, i - 10); j < i; j++) {
        if (index[j] * 2 > index[i - 1]) {
          next = Math.min(next, index[j] * 2);
        }
        if (index[j] * 3 > index[i - 1]) {
          next = Math.min(next, index[j] * 3);
        }
        if (index[j] * 5 > index[i - 1]) {
          next = Math.min(next, index[j] * 5);
        }
      }
      index[i] = next;
    }

    return (int) index[n - 1];
  }
}
