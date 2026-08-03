/*
------------------------------------------------------------
LeetCode 860 - Lemonade Change
------------------------------------------------------------

Pattern:
Greedy

Approach:
Always use larger bills first while giving change.
Keep track of the number of $5 and $10 bills.

Algorithm:
1. Traverse each customer's bill.
2. If customer pays with $5:
   - Increase count of $5 bills.
3. If customer pays with $10:
   - Need one $5 as change.
   - Decrease $5 count and increase $10 count.
4. If customer pays with $20:
   - Prefer giving one $10 + one $5.
   - Otherwise give three $5 bills.
   - If neither is possible, return false.
5. If all customers are served, return true.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Learning:
Always use the highest denomination possible while giving change because it preserves smaller bills for future customers.

------------------------------------------------------------
*/

class Solution {

    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            if (bill == 5) {
                five++;
            }

            else if (bill == 10) {

                if (five == 0)
                    return false;

                five--;
                ten++;
            }

            else {

                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }

                else if (five >= 3) {
                    five -= 3;
                }

                else {
                    return false;
                }
            }
        }

        return true;
    }
}
