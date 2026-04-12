// Approach:
// 1. If lengths are different, return false
// 2. Concatenate string with itself (s + s)
// 3. Check if goal is a substring of (s + s)
// 4. If yes, rotation is possible

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        return (s + s).contains(goal);
    }
}
