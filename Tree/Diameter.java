class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        // APPROACH:
        // 1. Diameter = longest path between any two nodes
        // 2. For each node:
        //    - Find left subtree height (l)
        //    - Find right subtree height (r)
        // 3. Possible diameter at that node = l + r
        // 4. Keep updating maximum diameter using an array (to pass by reference)
        // 5. Return height of current node = 1 + max(l, r)

        int[] dia = new int[1]; // stores max diameter
        height(root, dia);
        return dia[0];
    }

    private int height(TreeNode root, int[] dia) {
        if (root == null) return 0;

        int left = height(root.left, dia);
        int right = height(root.right, dia);

        // update diameter
        dia[0] = Math.max(dia[0], left + right);

        // return height
        return 1 + Math.max(left, right);
    }
}
