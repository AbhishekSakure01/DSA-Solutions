import java.util.*;

/*
    LeetCode 881 - Boats to Save People

    Problem Statement:
    You are given an array where each element represents the weight
    of a person and an integer limit representing the maximum weight
    a boat can carry.

    Each boat can carry at most two people.

    Return the minimum number of boats required to carry everyone.


    Approach:
    1. Sort the people's weights.
    2. Use two pointers:
       - left points to the lightest person.
       - right points to the heaviest person.
    3. If the lightest and heaviest people can fit together,
       put them in the same boat.
    4. Otherwise, the heaviest person must take a boat alone.
    5. Move the appropriate pointers and count every boat.


    Greedy Idea:
    Always consider the heaviest person first.

    If the heaviest person can share a boat with the lightest person,
    pair them together. Otherwise, the heaviest person must go alone.

    This minimizes the number of boats.


    Time Complexity:
    O(n log n)

    Space Complexity:
    O(1) excluding sorting space.
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {

        // Sort people by weight
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        // Try to pair the lightest person with the heaviest person
        while (left <= right) {

            // One boat is used for the heaviest remaining person
            boats++;

            // If the lightest and heaviest can share a boat
            if (people[left] + people[right] <= limit) {
                left++;
            }

            // Heaviest person is always placed in a boat
            right--;
        }

        return boats;
    }
}
