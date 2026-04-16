// Approach 1 (Iterative - Stack):
// 1. Use stack to simulate recursion
// 2. Push root node into stack
// 3. While stack is not empty:
//    - Pop node and add value to list
//    - Push right child first, then left (so left is processed first)
// 4. Return result

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            list.add(node.val);

            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }

        return list;
    }
}

// Approach 2 (Recursive - DFS):
// 1. Visit root node first
// 2. Recurse on left subtree
// 3. Recurse on right subtree
// 4. Store values in list

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);      // root
        dfs(node.left, list);    // left
        dfs(node.right, list);   // right
    }
}
