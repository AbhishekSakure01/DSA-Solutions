// Problem: Rearrange Array Elements by Sign

// Approach:
// Use two pointers:
// One for positive index (even positions)
// One for negative index (odd positions)
// Place elements accordingly

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int pi = 0; // positive index
        int ni = 1; // negative index

        int[] result = new int[n];

        for (int num : nums) {
            if (num > 0) {
                result[pi] = num;
                pi += 2;
            } else {
                result[ni] = num;
                ni += 2;
            }
        }

        return result;
    }
}
