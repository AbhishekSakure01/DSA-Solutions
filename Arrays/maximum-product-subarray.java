// Problem: Maximum Product Subarray

// Approach:
// Keep track of both max and min product
// Because negative numbers can flip sign
// If current number is negative, swap max and min
// Update max and min at each step

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(curr, max * curr);
            min = Math.min(curr, min * curr);

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
