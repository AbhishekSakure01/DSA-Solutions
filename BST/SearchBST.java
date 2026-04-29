class Solution {
    public TreeNode searchBST(TreeNode root, int val) {

        // Approach:
        // 1. Start from the root node.
        // 2. While current node is not null:
        //    a. If current node value == target → return node.
        //    b. If target < current value → move to left subtree.
        //    c. If target > current value → move to right subtree.
        // 3. If we reach null → value not found, return null.

        while (root != null && root.val != val) {
            // Move left if target is smaller
            if (val < root.val) {
                root = root.left;
            } 
            // Move right if target is greater
            else {
                root = root.right;
            }
        }

        // Either found node or null
        return root;
    }
}
