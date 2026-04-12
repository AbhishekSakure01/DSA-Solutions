// Approach:
// 1. Trim the string to remove leading/trailing spaces
// 2. Split using "\\s+" to handle multiple spaces
// 3. Reverse the array using two pointers
// 4. Join words with a single space

class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        int l = 0;
        int j = arr.length - 1;

        while (l < j) {
            String t = arr[l];
            arr[l] = arr[j];
            arr[j] = t;
            l++;
            j--;
        }

        return String.join(" ", arr);
    }
}
