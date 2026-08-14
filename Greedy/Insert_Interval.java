import java.util.*;

/*
    LeetCode 57 - Insert Interval

    Problem Statement:
    You are given a set of non-overlapping intervals sorted by their
    starting times and a new interval.

    Insert the new interval into the list of intervals and merge
    overlapping intervals.

    Example:
    intervals = [[1,3],[6,9]]
    newInterval = [2,5]

    Output:
    [[1,5],[6,9]]


    Approach:
    1. Traverse all intervals.
    2. Add intervals that end before the new interval starts.
    3. Merge all intervals that overlap with the new interval.
    4. Add the merged new interval.
    5. Add all remaining intervals after the new interval.
    6. Convert the result list into a 2D array.

    Greedy Idea:
    Process intervals in sorted order:
    - Before overlap: directly add the interval.
    - During overlap: expand the new interval.
    - After overlap: add the merged interval and remaining intervals.

    Time Complexity:
    O(n)

    Space Complexity:
    O(n)
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            // Interval is completely before the new interval
            if (end < newStart) {
                result.add(new int[]{start, end});
            }

            // Interval is completely after the new interval
            else if (start > newEnd) {

                // Add the new interval before moving to later intervals
                result.add(new int[]{newStart, newEnd});

                newStart = Integer.MAX_VALUE;
                newEnd = Integer.MAX_VALUE;

                result.add(new int[]{start, end});
            }

            // Intervals overlap, so merge them
            else {
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
        }

        // Add the merged/new interval if it has not been added yet
        if (newStart != Integer.MAX_VALUE) {
            result.add(new int[]{newStart, newEnd});
        }

        return result.toArray(new int[result.size()][]);
    }
}
