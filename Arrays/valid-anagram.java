// Problem: Valid Anagram

// Approach:
// Use frequency array to count characters in string s
// Decrease count using string t
// If all counts are zero, strings are anagrams

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }
}
