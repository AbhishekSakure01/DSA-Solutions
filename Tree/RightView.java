/**
 * APPROACH:
 * 
 * 1. We want the RIGHT VIEW of a binary tree → only one node per level (the rightmost one).
 * 
 * 2. Use DFS (recursion) and traverse:
 *        ROOT → RIGHT → LEFT
 *    (Important: Right first so we see rightmost nodes first)
 * 
 * 3. Keep track of current depth (level).
 * 
 * 4. At each node:
 *      - If depth == result.size()
 *        → It means we are visiting this level for the FIRST time
 *        → Add this node to result
 * 
 * 5. Since we visit RIGHT first,
 *    the first node at each level will always be the rightmost node.
 * 
 * 6. Recursively process:
 *        right subtree → left subtree
 * 
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(h)  (recursion stack)
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode curr, List<Integer> result, int depth) {
        if (curr == null) return;

        // If visiting this level for the first time → add node
        if (depth == result.size()) {
            result.add(curr.val);
        }

        // Visit right first (important for right view)
        rightView(curr.right, result, depth + 1);

        // Then visit left
        rightView(curr.left, result, depth + 1);
    }
}
