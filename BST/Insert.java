// Approach:
// 1. If root is null → create a new node and return it.
// 2. Compare given value with root node:
//    - If val > root.val → insert into right subtree.
//    - Else → insert into left subtree.
// 3. Use recursion to reach correct position.
// 4. After insertion, return the root node (important for linking).

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        // Base case: if tree is empty, create new node
        if (root == null) {
            return new TreeNode(val);
        }

        // If value is greater, go to right subtree
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } 
        // Otherwise go to left subtree
        else {
            root.left = insertIntoBST(root.left, val);
        }

        // Return the unchanged root
        return root;
    }
}
