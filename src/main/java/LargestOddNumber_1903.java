public class LargestOddNumber_1903 {

  public static void main(String[] args) {
    largestOddNumber("52");
  }

  public static String largestOddNumber(String num) {

    String rtn = "";
    char[] charArray = num.toCharArray();
    for (int i = charArray.length - 1; i >= 0; i--) {
      if ((charArray[i] & 1) == 1) {
        return String.copyValueOf(charArray, 0, i);
      }
    }
    return rtn;
  }
}
