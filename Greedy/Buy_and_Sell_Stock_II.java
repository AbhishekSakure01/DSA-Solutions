import java.util.*;

/*
    LeetCode 122 - Best Time to Buy and Sell Stock II

    Problem Statement:
    You are given an array where prices[i] represents the stock price
    on day i.

    You can buy and sell the stock multiple times, but you must sell
    before buying again.

    Return the maximum profit possible.


    Approach:
    1. Traverse the prices from left to right.
    2. Whenever today's price is greater than yesterday's price,
       take that profit.
    3. Add all positive price differences to get the maximum profit.


    Greedy Idea:
    Capture every profitable upward movement.

    Example:
    prices = [7,1,5,3,6,4]

    Profit:
    (5 - 1) + (6 - 3) = 7

    We do not need to explicitly decide the exact buy/sell days.
    Every positive difference contributes to the maximum profit.


    Time Complexity:
    O(n)

    Space Complexity:
    O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;

        // Add every profitable price increase
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
