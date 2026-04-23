/*
APPROACH (NO HASHMAP - USING LIMIT)

We use two pointers:
- preInd → to pick nodes from preorder (root creation)
- inInd  → to track inorder traversal (boundary check)

Key Idea:
- Preorder gives us ROOT (Root → Left → Right)
- Inorder tells us when to STOP (Left → Root → Right)

We use a "limit" to control subtree boundaries.

How it works:
1. Create node using preorder[preInd]
2. Move preInd forward
3. Build LEFT subtree with limit = current node value
   → because left subtree ends when we reach root in inorder
4. Build RIGHT subtree with same limit (parent boundary)

Important condition:
- If inorder[inInd] == limit → stop recursion
  → means we reached boundary of this subtree

Why inInd++?
- Because we finished processing that node in inorder

Time Complexity: O(n)
Space Complexity: O(h) recursion stack
*/


class Solution {

    int preInd; // pointer for preorder
    int inInd;  // pointer for inorder

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preInd = 0;
        inInd = 0;

        // Start with infinite limit (no boundary)
        return build(preorder, inorder, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int[] inorder, int limit) {

        // ✅ Base case: no more nodes to create
        if (preInd >= preorder.length) return null;

        // ✅ Stop condition using inorder
        // If current inorder value hits limit → subtree finished
        if (inorder[inInd] == limit) {
            inInd++;  // move inorder pointer forward
            return null;
        }

        // ✅ Create current node from preorder
        TreeNode curr = new TreeNode(preorder[preInd++]);

        // ✅ Build left subtree
        // Left subtree must stop when we reach curr.val in inorder
        curr.left = build(preorder, inorder, curr.val);

        // ✅ Build right subtree
        // Right subtree continues until parent limit
        curr.right = build(preorder, inorder, limit);

        return curr;
    }
}
