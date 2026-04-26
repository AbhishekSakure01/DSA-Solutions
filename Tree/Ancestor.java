/*
We are solving Lowest Common Ancestor (LCA) in a Binary Search Tree (BST).

Key Property of BST:
Left subtree values < root
Right subtree values > root

Steps:
1. If both p and q are smaller than root:
   → LCA must be in LEFT subtree → move left

2. If both p and q are greater than root:
   → LCA must be in RIGHT subtree → move right

3. Otherwise:
   → This is the split point
   → One node is on left and one on right (or one equals root)
   → So current root is the LCA

4. Base case:
   If root is null → return null
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Base case
        if (root == null) {
            return null;
        }

        // If both nodes are smaller → go left
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both nodes are greater → go right
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Split point → this is LCA
        return root;
    }
}
