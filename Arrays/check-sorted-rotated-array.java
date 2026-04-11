// Problem: Check if Array is Sorted and Rotated

// Approach:
// Count the number of places where nums[i] > nums[i+1]
// If more than one such place exists, array is not sorted & rotated

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int irregularities = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                irregularities++;
            }
        }

        return irregularities <= 1;
    }
}
