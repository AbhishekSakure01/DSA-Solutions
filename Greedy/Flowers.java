import java.util.*;

/*
    LeetCode 605 - Can Place Flowers

    Problem Statement:
    You are given a flowerbed represented by an array where:
    0 = empty
    1 = flower already planted

    Flowers cannot be planted in adjacent positions.

    Return true if n new flowers can be planted without violating
    the no-adjacent-flowers rule.


    Approach:
    1. Traverse the flowerbed from left to right.
    2. For every empty position, check its left and right neighbors.
    3. If both neighbors are empty (or outside the array), plant a flower.
    4. Decrease n after planting.
    5. If n becomes 0, return true.
    6. If the traversal finishes and flowers are still required,
       return false.


    Greedy Idea:
    Whenever we find a valid position, plant immediately.

    Planting at the earliest available valid position leaves the
    maximum possible space for the remaining flowers.


    Time Complexity:
    O(n)

    Space Complexity:
    O(1)
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            // Current position must be empty
            if (flowerbed[i] == 0) {

                // Check left and right positions
                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightEmpty = (
                    i == flowerbed.length - 1 ||
                    flowerbed[i + 1] == 0
                );

                // We can safely plant here
                if (leftEmpty && rightEmpty) {

                    flowerbed[i] = 1;
                    n--;

                    // All required flowers are planted
                    if (n == 0) {
                        return true;
                    }
                }
            }
        }

        return n <= 0;
    }
}
