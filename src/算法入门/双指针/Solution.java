package 算法入门.双指针;

import Utils.ArrayUtil;

import java.nio.charset.Charset;
import java.util.Arrays;

public class Solution {
    //977 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            int leftNum = (int) Math.pow(nums[left], 2);
            int rightNum = (int) Math.pow(nums[right], 2);
            if (rightNum >= leftNum) {
                result[index--] = rightNum;
                right--;
            } else {
                result[index--] = leftNum;
                left++;
            }
        }
        return result;
    }

    //189. 轮转数组
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        for (int i = 0;i<s1.length;i++) {
            char[] chars = s1[i].toCharArray();
            reverseString(chars);
            s1[i] = String.valueOf(chars);
        }
        return String.join(" ", s1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = ArrayUtil.stringToIntArray("[1,2,3,4,5,6,7]");
        s.rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
    }
}
