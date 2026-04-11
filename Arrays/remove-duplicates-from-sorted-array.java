// Problem: Remove Duplicates from Sorted Array

// Approach:
// Use two pointers:
// One pointer (i) tracks unique elements
// Another pointer (j) scans the array
// When a new element is found, move i and update value

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
