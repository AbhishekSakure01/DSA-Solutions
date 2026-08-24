import java.util.*;

/*
    LeetCode 948 - Bag of Tokens

    Problem Statement:
    You are given an array of token values and an initial amount of power.

    Rules:
    - If you have enough power, you can play a token face up:
        power decreases by token value
        score increases by 1

    - If you have at least 1 score, you can play a token face down:
        power increases by token value
        score decreases by 1

    Return the maximum score possible.


    Approach:
    1. Sort the tokens.
    2. Use two pointers:
       - left points to the smallest token.
       - right points to the largest token.
    3. If we have enough power, play the smallest token face up
       to increase the score.
    4. Otherwise, if we have a score, play the largest token face down
       to gain power.
    5. Keep track of the maximum score.


    Greedy Idea:
    When gaining score, always use the smallest token because it
    requires the least power.

    When gaining power, always sacrifice the largest token because
    it gives the maximum possible power.


    Time Complexity:
    O(n log n)

    Space Complexity:
    O(1) excluding sorting space.
*/

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {

        // Sort tokens so we can use the smallest and largest tokens greedily
        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int score = 0;
        int maxScore = 0;

        while (left <= right) {

            // Use the smallest token to gain score
            if (power >= tokens[left]) {

                power -= tokens[left];
                score++;
                left++;

                maxScore = Math.max(maxScore, score);
            }

            // Use the largest token to gain power
            else if (score > 0) {

                power += tokens[right];
                score--;
                right--;
            }

            // Cannot gain score or power
            else {
                break;
            }
        }

        return maxScore;
    }
}
