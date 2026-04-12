// # Remove Outer Parentheses

// ## 🧠 Approach
// We use a counter to track the depth of parentheses.

// - Traverse the string character by character
// - If it's '(', increase count
//   - Add it only if count is already greater than 0
// - If it's ')', decrease count
//   - Add it only if count is still greater than 0 after decrement
// - This removes the outermost parentheses

// **Time Complexity:** O(n)  
// **Space Complexity:** O(n)

// ---

// ## 💻 Code (Java)

// ```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count != 0) sb.append(c);
                count++;
            } else {
                count--;
                if (count != 0) sb.append(c);
            }
        }
        return sb.toString();
    }
}
