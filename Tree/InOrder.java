// Approach 1 (Iterative - Stack):
// 1. Use stack to traverse leftmost nodes first
// 2. Keep pushing nodes while going left
// 3. When null, pop from stack and process node
// 4. Move to right subtree
// 5. Repeat until stack is empty

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;

                node = st.pop();
                list.add(node.val);
                node = node.right;
            }
        }

        return list;
    }
}

// Approach 2 (Recursive - DFS):
// 1. Recurse on left subtree
// 2. Visit root node
// 3. Recurse on right subtree
// 4. Store values in list

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;

        dfs(node.left, list);    // left
        list.add(node.val);      // root
        dfs(node.right, list);   // right
    }
}
