import java.util.*;

/*
    LeetCode 56 - Merge Intervals

    Problem Statement:
    Given an array of intervals where intervals[i] = [start, end],
    merge all overlapping intervals and return the non-overlapping
    intervals that cover all the intervals in the input.

    Example:
    Input:
    [[1,3],[2,6],[8,10],[15,18]]

    Output:
    [[1,6],[8,10],[15,18]]


    Approach:
    1. Sort all intervals by their starting point.
    2. Start with the first interval as the current interval.
    3. Traverse the remaining intervals.
    4. If the current interval overlaps with the next interval,
       merge them by updating the ending point.
    5. If there is no overlap, add the current interval to the result
       and start a new current interval.
    6. Add the final interval to the result.


    Greedy Idea:
    After sorting by start time, always keep the interval with the
    farthest ending point among overlapping intervals.


    Time Complexity:
    O(n log n)

    Space Complexity:
    O(n)
*/

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // Start with the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Current interval overlaps with the next interval
            if (intervals[i][0] <= end) {

                // Merge by extending the ending point
                end = Math.max(end, intervals[i][1]);

            } else {

                // No overlap, so store the current interval
                result.add(new int[]{start, end});

                // Start a new interval
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
