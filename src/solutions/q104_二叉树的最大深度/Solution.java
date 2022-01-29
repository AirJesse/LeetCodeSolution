package solutions.q104_二叉树的最大深度;


import common.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(maxDepth(node.left, depth + 1), maxDepth(node.right, depth + 1));
    }


}
