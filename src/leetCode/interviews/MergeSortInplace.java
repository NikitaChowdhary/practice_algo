package leetCode.interviews;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */
public class MergeSortInplace {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m; int i2 = n, i = m + n - 1;
        for (; i >=0 && i1 >=1 && i2>=1; i--) {
            if (nums1[i1 - 1] >= nums2[i2 - 1]) {
                nums1[i] = nums1[i1 - 1];
                i1--;
            } else {
                nums1[i] = nums2[i2 - 1];
                i2--;
            }
        }

        if (i2 >=1) {
            for (int k= i2; k>=1; k--) {
                nums1[i--] = nums2[k-1];
            }
        }
    }
}
