// Problem: Two Sum

// Approach:
// Use HashMap to store numbers and their indices
// For each element, check if (target - element) exists in map

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
