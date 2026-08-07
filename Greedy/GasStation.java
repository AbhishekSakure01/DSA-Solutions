/*
------------------------------------------------------------
LeetCode 134 - Gas Station
------------------------------------------------------------

Pattern:
Greedy

Approach:
1. If total gas is less than total cost, completing the circuit is impossible.
2. Traverse all stations while maintaining current fuel.
3. If current fuel becomes negative, the current starting station cannot complete the journey.
4. Reset current fuel and choose the next station as the new starting point.
5. Return the starting station if total gas >= total cost.

Time Complexity:
O(n)

Space Complexity:
O(1)

------------------------------------------------------------
*/

class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];
            totalCost += cost[i];

            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }

        return totalGas >= totalCost ? start : -1;
    }
}
