class Solution {

    /*
    🔑 APPROACH (Range / Min-Max Method)

    1. A Binary Search Tree (BST) follows:
       - All nodes in left subtree < root
       - All nodes in right subtree > root
       - This must be true for EVERY node (global property)

    2. Instead of checking only immediate children,
       we maintain a VALID RANGE (min, max) for each node.

    3. Rules:
       - Root can be anything → range (-∞, +∞)
       - For left child → range (min, root.val)
       - For right child → range (root.val, max)

    4. At each node:
       - If node.val is NOT in (min, max) → ❌ invalid BST
       - Otherwise → recursively check left & right

    5. Why use long?
       - To handle edge cases like Integer.MIN_VALUE / MAX_VALUE

    ⏱️ Time Complexity: O(N)
    🧠 Space Complexity: O(H) (recursion stack)

    ✔️ This ensures GLOBAL BST validation (not just local checks)
    */

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long min, long max) {
        if (root == null) return true;

        // ❌ violates BST property
        if (root.val <= min || root.val >= max) return false;

        // ✅ check subtrees with updated ranges
        return validate(root.left, min, root.val) &&
               validate(root.right, root.val, max);
    }
}
