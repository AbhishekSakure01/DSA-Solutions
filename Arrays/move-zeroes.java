// Problem: Move Zeroes

// Approach:
// Use two pointers:
// One pointer (i) tracks position for non-zero elements
// Another pointer (j) scans the array
// Swap when non-zero is found

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}
