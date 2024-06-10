import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

  public static void main(String[] args) {

    isHappy(2);
  }

  public static boolean isHappy(int n) {

    Set<Integer> set = new HashSet<>();
    int rtn = 0;
    while (true) {
      rtn += (n % 10) * (n % 10);
      n /= 10;


      if(n == 0){
        if(rtn == 1){
          return true;
        }
        if(set.contains(rtn)){
          return false;
        }
        set.add(rtn);
        n = rtn;
        rtn = 0;
      }
    }
  }
}
