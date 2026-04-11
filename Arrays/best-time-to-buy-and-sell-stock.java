// Problem: Best Time to Buy and Sell Stock

// Approach:
// Track minimum buying price so far
// For each day, calculate profit = current price - min price
// Update maximum profit

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else {
                int profit = price - buy;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
