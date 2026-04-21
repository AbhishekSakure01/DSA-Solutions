/**
 * Approach:
 * 1. A tree is symmetric if its left and right subtrees are mirror images.
 * 2. For mirror check:
 *    - If both nodes are null → symmetric (true)
 *    - If one is null → not symmetric (false)
 *    - If values are different → not symmetric (false)
 * 3. Recursively check:
 *    - left subtree's left with right subtree's right
 *    - left subtree's right with right subtree's left
 * 4. If all conditions satisfy → tree is symmetric
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) (recursion stack)
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Empty tree is always symmetric
        if (root == null) return true;

        // Check mirror condition
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // If both are null → symmetric
        if (left == null && right == null) return true;

        // If one is null → not symmetric
        if (left == null || right == null) return false;

        // Values must be equal
        if (left.val != right.val) return false;

        // Recursive mirror check
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
