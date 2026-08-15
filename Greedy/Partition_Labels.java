import java.util.*;

/*
    LeetCode 763 - Partition Labels

    Problem Statement:
    Given a string s, partition it into as many parts as possible so that
    each letter appears in at most one part.

    Return a list of the sizes of these parts.

    Example:
    Input:
    s = "ababcbacadefegdehijhklij"

    Output:
    [9,7,8]


    Approach:
    1. Find the last occurrence of every character.
    2. Traverse the string from left to right.
    3. For the current character, find its last occurrence.
    4. Keep extending the current partition boundary to the farthest
       last occurrence of any character inside the partition.
    5. When the current index reaches the boundary, the partition is complete.
    6. Add its size to the result and start the next partition.


    Greedy Idea:
    For every partition, extend its boundary to the last occurrence
    of every character seen so far.

    Once we reach that boundary, none of those characters appear later,
    so we can safely close the partition.


    Time Complexity:
    O(n)

    Space Complexity:
    O(1)
*/

class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        int[] last = new int[26];

        // Store the last occurrence of every character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        // Build each partition
        for (int i = 0; i < s.length(); i++) {

            // Extend partition boundary
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // Partition is complete
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
