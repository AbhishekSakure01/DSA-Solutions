public class Codec {

    // APPROACH:
    // Use BFS (level order traversal) with a queue
    // Store node values and "null" to preserve structure

    // SERIALIZE: Tree → String
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                res.append("null ");
            } else {
                res.append(node.val).append(" ");
                q.add(node.left);   // push left child
                q.add(node.right);  // push right child
            }
        }

        return res.toString().trim(); // remove extra space
    }

    // DESERIALIZE: String → Tree
    public TreeNode deserialize(String data) {

        // empty string means no tree
        if (data == null || data.length() == 0) return null;

        String[] values = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();

        // first value is root
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        int i = 1;

        // process nodes level by level
        while (!q.isEmpty() && i < values.length) {
            TreeNode parent = q.poll();

            // LEFT CHILD
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            i++;

            // RIGHT CHILD
            if (i < values.length && !values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
    }
}
