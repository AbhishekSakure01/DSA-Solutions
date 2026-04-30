// APPROACH:
//
// 1. Ceil means the smallest value in BST that is >= x.
//
// 2. Use BST property:
//    - Left subtree → smaller values
//    - Right subtree → larger values
//
// 3. Start from root and traverse:
//    a) If root.data == x:
//       → exact match → return it as ceil
//
//    b) If root.data < x:
//       → current node cannot be ceil
//       → move to right subtree
//
//    c) If root.data > x:
//       → this can be a possible ceil
//       → store it
//       → move to left subtree to find a smaller valid ceil
//
// 4. Continue until root becomes null
//
// 5. Return stored ceil (if not found, return -1)


class Solution {
    int findCeil(Node root, int x) {
        
        int ceil = -1;
        
        while (root != null) {
            
            if (root.data == x) {
                return root.data;
            }
            else if (root.data < x) {
                root = root.right;
            }
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        
        return ceil;
    }
}
