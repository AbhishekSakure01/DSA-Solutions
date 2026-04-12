// Approach:
// 1. Map Roman characters to their integer values
// 2. Traverse the string from left to right
// 3. If current value is less than next value, subtract it
// 4. Otherwise, add it to total
// 5. Return the final result

class Solution {
    public int romanToInt(String s) {
        int[] values = new int[128];

        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentValue = values[s.charAt(i)];

            if (i + 1 < s.length() && currentValue < values[s.charAt(i + 1)]) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
        }
        return total;
    }
}
