import java.util.*;

/*
    LeetCode 402 - Remove K Digits

    Problem Statement:
    Given a non-negative integer represented as a string num,
    remove exactly k digits so that the resulting number is the
    smallest possible number.

    Example:
    num = "1432219"
    k = 3

    Output:
    "1219"


    Approach:
    1. Use a monotonic increasing stack.
    2. Traverse each digit from left to right.
    3. If the current digit is smaller than the stack top,
       remove the larger previous digit while k > 0.
    4. Push the current digit.
    5. If k is still greater than 0 after traversal, remove digits
       from the end.
    6. Remove leading zeros.
    7. If the result becomes empty, return "0".


    Greedy Idea:
    To make the number as small as possible, remove a digit that is
    larger than the digit immediately following it.

    Example:
    "143..."
       ↑
       4 > 3

    Removing 4 gives a smaller number.


    Time Complexity:
    O(n)

    Space Complexity:
    O(n)
*/

class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (char digit : num.toCharArray()) {

            // Remove larger previous digits
            while (!st.isEmpty() &&
                   k > 0 &&
                   st.peek() > digit) {

                st.pop();
                k--;
            }

            st.push(digit);
        }

        // If digits still need to be removed,
        // remove them from the end.
        while (k > 0) {
            st.pop();
            k--;
        }

        // Build result
        StringBuilder result = new StringBuilder();

        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        result.reverse();

        // Remove leading zeros
        int i = 0;

        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }

        result = new StringBuilder(result.substring(i));

        // If nothing remains, return "0"
        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }
}
