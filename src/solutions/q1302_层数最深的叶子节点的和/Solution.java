package solutions.q1302_层数最深的叶子节点的和;

import common.TreeNode;

import java.awt.*;

public class Solution {
    int maxDepth = 0;
    int result = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return result;
    }

    private void dfs(TreeNode node, int depth) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left == null & right == null) {
            if (depth == maxDepth) {
                result += node.val;
            } else if (depth > maxDepth) {
                maxDepth = depth;
                result = node.val;
            }
        }
        if (left != null) {
            dfs(node.left, depth + 1);
        }
        if (right != null) {
            dfs(node.right, depth + 1);
        }
    }
}
