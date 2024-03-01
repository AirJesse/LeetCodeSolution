package solutions.q654_最大二叉树;

import common.TreeNode;

import java.util.Arrays;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxIndex = findMaxIndex(nums);
        TreeNode node = new TreeNode(nums[maxIndex]);
        if (maxIndex != 0) {
            node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        }
        if (maxIndex != nums.length - 1) {
            node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
        }
        return node;
    }

    private int findMaxIndex(int[] nums) {
        int max = -1;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max= nums[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = 2;
        do {i*=i;} while (i<24);
        System.out.println(i);
    }
}
