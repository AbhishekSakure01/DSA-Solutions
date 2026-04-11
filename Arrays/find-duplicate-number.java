// Problem: Contains Duplicate

// Approach:
// Used HashMap to count frequency of elements.
// If any element appears more than once, return true.

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > 1){
                return true;
            }
        }
        return false;
    }
}

// OR YOU CAN USE HASHSET ALSO

// Approach:
// Use HashSet to track visited elements.
// If element already exists, duplicate found.

class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
