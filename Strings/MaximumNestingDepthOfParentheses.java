// Approach:
// 1. Traverse the string and maintain a counter for '('
// 2. Increment count for '(' and decrement for ')'
// 3. Track the maximum value of count during traversal
// 4. Return the maximum depth

class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                }
            } else if (c == ')') {
                count--;
            }
        }
        return maxCount;
    }
}
