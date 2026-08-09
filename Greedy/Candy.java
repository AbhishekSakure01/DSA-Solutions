import java.util.*;

/*
------------------------------------------------------------
LeetCode 135 - Candy
------------------------------------------------------------

Pattern:
Greedy

Approach:
We need to give every child at least one candy.

If a child has a higher rating than a neighboring child,
the child must receive more candies.

We solve this using two passes:
1. Left to Right
2. Right to Left

Algorithm:
1. Create a candies array and initialize every value to 1.
2. Traverse from left to right.
   If ratings[i] > ratings[i - 1], give the current child
   one more candy than the previous child.
3. Traverse from right to left.
   If ratings[i] > ratings[i + 1], update the candy count.
   Use Math.max() because the child may already have received
   more candies during the first traversal.
4. Add all candy values and return the total.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Learning:
When a greedy condition depends on both left and right
neighbors, we can handle each direction separately using
two passes.

------------------------------------------------------------
*/

class Solution {

    public int candy(int[] ratings) {

        // Give every child at least one candy.
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        int total = 0;

        // Left to Right
        // Handle the condition with the left neighbor.
        for (int i = 1; i < ratings.length; i++) {

            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left
        // Handle the condition with the right neighbor.
        for (int i = ratings.length - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(
                    candies[i],
                    candies[i + 1] + 1
                );
            }
        }

        // Calculate total candies.
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}
