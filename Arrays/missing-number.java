// Problem: Missing Number

// Approach:
// Use sum formula n*(n+1)/2 to get expected sum
// Subtract all elements from it
// Remaining value is the missing number

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            total -= nums[i];
        }

        return total;
    }
}
