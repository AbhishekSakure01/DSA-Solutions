/*
    LeetCode 226 - Invert Binary Tree

    Approach:
    Recursively invert the left and right subtrees,
    then swap them.

    Time Complexity: O(n)
    Space Complexity: O(h)
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
