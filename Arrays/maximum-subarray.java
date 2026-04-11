// Problem: Maximum Subarray

// Approach:
// Use Kadane’s Algorithm
// Keep track of current sum
// If current sum becomes negative, reset it to 0
// Track maximum sum throughout

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currSum += num;
            maxSum = Math.max(maxSum, currSum);

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}
