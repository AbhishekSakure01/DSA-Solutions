import java.util.*;

/*
    LeetCode 452 - Minimum Number of Arrows to Burst Balloons

    Problem Statement:
    You are given a 2D array where each element represents a balloon
    as an interval [start, end].

    An arrow can be shot vertically at any position x.
    A balloon is burst if start <= x <= end.

    Find the minimum number of arrows required to burst all balloons.


    Approach:
    1. Sort all balloons based on their ending point.
    2. Place the first arrow at the end of the first balloon.
    3. For every next balloon:
       - If its starting point is <= current arrow position,
         the same arrow can burst it.
       - Otherwise, we need a new arrow.
    4. Place the new arrow at the ending point of that balloon.
    5. Return the total number of arrows.

    Greedy Idea:
    Always place the arrow at the earliest possible ending point.
    This gives the arrow the maximum chance to burst upcoming
    overlapping balloons.
*/

class Solution {
    public int findMinArrowShots(int[][] points) {

        // Sort balloons by their ending points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // Place the first arrow at the end of the first balloon
        int arrows = 1;
        int arrowPosition = points[0][1];

        // Check all remaining balloons
        for (int i = 1; i < points.length; i++) {

            // If the current balloon starts after the arrow,
            // the existing arrow cannot burst this balloon
            if (points[i][0] > arrowPosition) {

                // Need a new arrow
                arrows++;

                // Place the new arrow at this balloon's end
                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }
}
