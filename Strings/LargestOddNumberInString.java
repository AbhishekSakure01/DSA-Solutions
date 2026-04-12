// Approach:
// 1. Traverse the string from right to left
// 2. Find the first odd digit
// 3. Return substring from start to that index
// 4. If no odd digit found, return empty string

class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();

        for (int i = n - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
