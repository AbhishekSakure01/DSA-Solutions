/*
------------------------------------------------------------
LeetCode 45 - Jump Game II
------------------------------------------------------------

Pattern:
Greedy

Approach:
Keep track of the farthest index reachable within the current jump.
When we reach the end of the current jump range, we must make another jump
and update the range to the farthest reachable index.

Algorithm:
1. Initialize jumps = 0, currentEnd = 0, farthest = 0.
2. Traverse the array until n - 2.
3. Update farthest = max(farthest, i + nums[i]).
4. If i reaches currentEnd:
      - Increment jumps.
      - Update currentEnd = farthest.
5. Return jumps.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Learning:
Instead of deciding where to jump next,
always keep track of the farthest position reachable in the current range.

------------------------------------------------------------
*/

class Solution {

    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
