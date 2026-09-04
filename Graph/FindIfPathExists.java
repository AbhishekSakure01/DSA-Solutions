/*
Problem:
LeetCode 1971 - Find if Path Exists in Graph

Pattern:
Graph + Adjacency List + DFS

Approach:
Convert the edges into an adjacency list.
Start DFS from the source node and try to reach the destination.
Use a visited array to avoid visiting the same node repeatedly.

Algorithm:
1. Create an adjacency list for all nodes.
2. For every undirected edge, add both directions.
3. Create a visited array.
4. Start DFS from source.
5. If current node is destination, return true.
6. Mark current node as visited.
7. Visit every unvisited neighbor recursively.
8. If no path is found, return false.

Time Complexity:
O(V + E)

Space Complexity:
O(V + E)

Key Learning:
In an undirected graph, every edge is added in both directions.
DFS explores the graph deeply while visited[] prevents cycles.
*/

import java.util.*;

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges in both directions
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Track visited nodes
        boolean[] visited = new boolean[n];

        // Start DFS from source
        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int node, int destination,
                        ArrayList<ArrayList<Integer>> graph,
                        boolean[] visited) {

        // Destination reached
        if (node == destination) {
            return true;
        }

        // Mark current node as visited
        visited[node] = true;

        // Explore neighbors
        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, destination, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
