public class MaximumNumber_1456 {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    public static int maxVowels(String s, int k) {

        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < k; i++) {
            chars[i] = find(chars[i]);
            max += chars[i] - '0';
        }
        if (max == k) {
            return k;
        }
        int c = max;
        for (int i = k; i < s.length(); i++) {
            chars[i] = find(chars[i]);
            c += chars[i] - chars[i - k];
            max = Math.max(max, c);
        }
        return max;
    }

    private static char find(char i) {
        return i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' ? '1' : '0';
    }
}
