// Start from root
// Initialize floor = -1

// While root is not null:
//   If root.data <= x:
//       Store it as possible floor
//       Move to right (to find closer value)

//   Else:
//       Move to left

// Return floor

class Solution {
    int findFloor(Node root, int x) {
        int floor = -1;

        while (root != null) {
            if (root.data <= x) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
