/*
Problem:
LeetCode 733 - Flood Fill

Pattern:
Grid DFS / Flood Fill

Approach:
Start DFS from the given starting cell.
Find the original color of the starting cell.
Change every connected cell having the same original color
to the new color.

Algorithm:
1. Store the original color.
2. If original color == new color, return the image.
3. Start DFS from (sr, sc).
4. Stop if the cell is outside the grid.
5. Stop if the cell does not have the original color.
6. Change the current cell to the new color.
7. Explore up, down, left, and right.
8. Return the modified image.

Time Complexity:
O(m × n)

Space Complexity:
O(m × n) in the worst case due to DFS recursion.

Key Learning:
Flood Fill is a grid DFS pattern.
The original color determines which cells belong to the region,
while the new color replaces those cells.
Changing the cell to the new color also marks it as visited.
*/

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int i, int j,
                     int originalColor, int color) {

        if (i < 0 || i >= image.length ||
            j < 0 || j >= image[0].length ||
            image[i][j] != originalColor) {
            return;
        }

        image[i][j] = color;

        dfs(image, i - 1, j, originalColor, color);
        dfs(image, i + 1, j, originalColor, color);
        dfs(image, i, j - 1, originalColor, color);
        dfs(image, i, j + 1, originalColor, color);
    }
}
