// Approach:
// 1. Use a frequency array of size 26 for lowercase letters
// 2. Increment count for each character in s
// 3. Decrement count for each character in t
// 4. If any value is not zero, strings are not anagrams

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for (int ch : freq) {
            if (ch != 0) {
                return false;
            }
        }
        return true;
    }
}
