package 算法入门.二分查找;

import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index  = (left+right)/2;
            if(nums[index] == target){
                return index;
            }
            if(nums[index] > target){
                right = index-1;
            }else{
                left = index+1;
            }
        }
        return -1;
    }



    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        return i>=0?i: (-i-1);
    }


    public static void main(String[] args) {
        Solution s= new Solution();

    }
}
