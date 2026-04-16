// Approach (Recursive - DFS):
// 1. If node is null → return 0
// 2. Recursively find depth of left subtree
// 3. Recursively find depth of right subtree
// 4. Return 1 + max(left, right)

class Solution {
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1 + Math.max(l, r);
    }
}
