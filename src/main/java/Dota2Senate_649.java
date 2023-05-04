import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate_649 {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("DRRDRDRDRDD"));
    }

    public static String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        Deque<Integer> rQue = new ArrayDeque<>();
        Deque<Integer> dQue = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                rQue.offer(i);
            } else {
                dQue.offer(i);
            }
        }
        while (!rQue.isEmpty() && !dQue.isEmpty()) {
            Integer r = rQue.pollFirst();
            Integer d = dQue.pollFirst();
            if (r > d) {
                dQue.offer(d + senate.length());
            } else {
                rQue.offer(r + senate.length());
            }
        }
        return rQue.isEmpty() ? "Dire" : "Radiant";
    }
}
