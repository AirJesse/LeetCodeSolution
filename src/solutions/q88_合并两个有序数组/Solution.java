package solutions.q88_合并两个有序数组;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int leftIndex = m - 1;
        int rightIndex = n - 1;
        while (index >= 0) {
            int left = leftIndex < 0 ? Integer.MIN_VALUE : nums1[leftIndex];
            int right = rightIndex < 0 ? Integer.MIN_VALUE : nums2[rightIndex];
            if (left >= right) {
                nums1[index--] = left;
                leftIndex--;
            } else {
                nums1[index--] = right;
                rightIndex--;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[index--] = nums1[--m];
            } else {
                nums1[index--] = nums2[--n];
            }
        }
    }
}
