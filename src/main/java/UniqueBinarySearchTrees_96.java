import java.util.Arrays;

public class UniqueBinarySearchTrees_96 {

    public static void main(String[] args) {
        System.out.println(numTrees(20));
    }

    public static int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }
        return arr[n];
    }
}
