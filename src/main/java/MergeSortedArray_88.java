public class MergeSortedArray_88 {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int indexM = 0;
        int indexN = 0;
        int index = 0;
        int[] tmp = new int[m + n];

        while (indexN < n && indexM < m) {
            if(nums1[indexM] < nums2[indexN]){
                tmp[index++] = nums1[indexM++];
            }else {
                tmp[index++] = nums2[indexN++];
            }
        }

        for (int i = indexM; i < m; i++) {
            tmp[index++] = nums1[i];
        }

        for (int i = indexN; i < n; i++) {
            tmp[index++] = nums2[i];
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = tmp[i];
        }
    }
}
