// 🌳 Same Tree (Recursive - DFS)

// 1. If both nodes are null -> return true
// 2. If one node is null -> return false
// 3. If values are different -> return false
// 4. Recursively check left subtree
// 5. Recursively check right subtree
// 6. Return left && right

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 1 & 2. Null handling
        if (p == null || q == null) return (p == q);

        // 3,4,5,6. Check value + recurse
        return (p.val == q.val) &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
