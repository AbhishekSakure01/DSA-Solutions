/*
------------------------------------------------------------
LeetCode 55 - Jump Game
------------------------------------------------------------

Pattern:
Greedy

Approach:
Maintain the farthest index that can be reached.
If the current index becomes greater than the farthest reachable
index, then it is impossible to reach the end.

Algorithm:
1. Initialize farthest = 0.
2. Traverse the array.
3. If i > farthest, return false.
4. Update farthest = Math.max(farthest, i + nums[i]).
5. If farthest reaches the last index, return true.
6. After the loop, return true.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Learning:
Instead of checking every jump, always track the farthest position
you can reach.

------------------------------------------------------------
*/

class Solution {

    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index cannot be reached
            if (i > farthest) {
                return false;
            }

            // Update farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // Already reached or crossed last index
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
