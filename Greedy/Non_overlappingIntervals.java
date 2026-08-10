import java.util.*;

/*
------------------------------------------------------------
LeetCode 435 - Non-overlapping Intervals
------------------------------------------------------------

Pattern:
Greedy + Sorting

Approach:
We need to remove the minimum number of intervals so that
the remaining intervals do not overlap.

Instead of thinking about which interval to remove,
we choose which interval to keep.

The best greedy choice is to keep the interval that ends
earlier. This leaves more space for the remaining intervals.

Algorithm:
1. Sort intervals by their ending time in ascending order.
2. Keep track of the end of the last selected interval.
3. Traverse the intervals:
   - If the current interval starts before the previous
     interval ends, they overlap.
   - Remove the current interval and increase the count.
   - Otherwise, keep the current interval and update the end.
4. Return the number of removed intervals.

Time Complexity:
O(n log n)

Space Complexity:
O(1) excluding the sorting space.

Key Learning:
When selecting non-overlapping intervals, choosing the interval
with the earliest ending time leaves the maximum possible space
for future intervals.

------------------------------------------------------------
*/

class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals by their ending time.
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int removed = 0;

        // End of the last interval we decided to keep.
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Current interval overlaps with the previous
            // selected interval.
            if (intervals[i][0] < end) {

                removed++;

            } else {

                // No overlap, so keep this interval.
                end = intervals[i][1];
            }
        }

        return removed;
    }
}
