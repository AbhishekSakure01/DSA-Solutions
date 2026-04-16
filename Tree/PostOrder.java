// Approach 1 (Iterative - Two Stacks):
// 1. Use two stacks (st1, st2)
// 2. Push root to st1
// 3. Pop from st1 and push into st2
// 4. Push left and right children into st1
// 5. Finally, pop all elements from st2 → postorder

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) return new ArrayList<>();

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> list = new ArrayList<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);

            if (node.left != null) st1.push(node.left);
            if (node.right != null) st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            list.add(st2.pop().val);
        }

        return list;
    }
}

// Approach 2 (Recursive - DFS):
// 1. Recurse on left subtree
// 2. Recurse on right subtree
// 3. Visit root node
// 4. Store values in list

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;

        dfs(node.left, list);    // left
        dfs(node.right, list);   // right
        list.add(node.val);      // root
    }
}
