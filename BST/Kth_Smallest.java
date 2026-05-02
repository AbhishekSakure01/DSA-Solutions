/*
In BST, inorder traversal (Left → Root → Right) gives sorted order.

Steps:
1. Traverse left subtree
2. Decrement k when visiting node
3. When k == 0 → answer found
4. Otherwise go right
*/
class Solution {
    int count = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            ans = node.val;
            return;
        }

        inorder(node.right, k);
    }
}
