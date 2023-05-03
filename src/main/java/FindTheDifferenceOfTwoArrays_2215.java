import java.util.*;

public class FindTheDifferenceOfTwoArrays_2215 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();

        for (int i : nums1) {
            num1Set.add(i);
        }
        for (int i : nums2) {
            num2Set.add(i);
        }

        Iterator<Integer> iterator = num2Set.iterator();
        while (iterator.hasNext()) {
            if (num1Set.remove(iterator.next())) {
                iterator.remove();
            }
        }


        return List.of(new ArrayList<>(num1Set), new ArrayList<>(num2Set));
    }
}
