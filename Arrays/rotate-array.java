// Problem: Rotate Array

// Approach:
// Reverse entire array
// Reverse first k elements
// Reverse remaining elements
// This rotates array to the right by k steps

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int st, int ed) {
        while (st < ed) {
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            st++;
            ed--;
        }
    }
}
