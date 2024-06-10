public class AddDigit_258 {

  public static void main(String[] args) {}

  public int addDigits(int num) {
    return num >= 10 ? addDigits(num % 10 + addDigits(num / 10)) : num;
  }
}
