/*
------------------------------------------------------------
LeetCode 455 - Assign Cookies
------------------------------------------------------------

Problem:
You are given two arrays:
g[] -> greed factor of each child
s[] -> size of each cookie

Each child can receive at most one cookie.
A child is satisfied if:
cookieSize >= greedFactor

Return the maximum number of satisfied children.

------------------------------------------------------------
Pattern:
Greedy + Sorting

------------------------------------------------------------
Approach:
1. Sort both arrays.
2. Give the smallest possible cookie to the least greedy child.
3. If the cookie satisfies the child:
      - Count the child.
      - Move both pointers.
4. Otherwise:
      - Try a bigger cookie.

------------------------------------------------------------
Algorithm:
1. Sort greed array.
2. Sort cookie array.
3. Use two pointers.
4. Traverse both arrays.
5. Return count.

------------------------------------------------------------
Time Complexity:
O(n log n + m log m)

Space Complexity:
O(1)

------------------------------------------------------------
Key Learning:
✔ Greedy always makes the locally optimal choice.
✔ Use the smallest cookie that can satisfy the current child.
✔ Never waste a large cookie on a less greedy child.

------------------------------------------------------------
*/

class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {

            if (s[cookie] >= g[child]) {
                child++;
            }

            cookie++;
        }

        return child;
    }
}
