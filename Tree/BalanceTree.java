// 1. Use DFS to calculate height of left and right subtree
//
// 2. For every node:
//    - Find left subtree height
//    - Find right subtree height
//
// 3. If absolute difference of heights > 1
//    then tree is not balanced
//
// 4. Instead of checking heights repeatedly,
//    return:
//       - height value -> if subtree is balanced
//       - -1 -> if subtree is unbalanced
//
// 5. If any subtree returns -1,
//    directly return -1 upwards
//
// 6. If whole tree never returns -1,
//    then tree is balanced

class Solution {

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {

        if(root == null) return 0;

        int l = dfsHeight(root.left);

        if(l == -1) return -1;

        int r = dfsHeight(root.right);

        if(r == -1) return -1;

        if(Math.abs(l - r) > 1)
            return -1;

        return Math.max(l, r) + 1;
    }
}
