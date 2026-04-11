// Problem: Max Consecutive Ones

// Approach:
// Traverse array and count consecutive 1s
// Reset count when 0 is found
// Track maximum count

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;
    }
}
