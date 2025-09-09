import java.util.*;

class GraphCycleDetector {
    // Function to check if the undirected graph contains a cycle
    public static boolean hasCycle(int V, List<int[]> edges) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Map to count parallel edges
        Map<String, Integer> edgeCount = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Generate a unique key for undirected edge
            String key = u < v ? u + "-" + v : v + "-" + u;

            edgeCount.put(key, edgeCount.getOrDefault(key, 0) + 1);

            // Add to adjacency list
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Check for parallel edges (cycle of length 2)
        for (int count : edgeCount.values()) {
            if (count > 1) return true;
        }

        // Step 3: DFS to detect cycle
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Helper DFS function to detect cycles
    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Visited and not the parent → cycle
                return true;
            }
        }

        return false;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test Case 1
        int V1 = 5;
        List<int[]> edges1 = Arrays.asList(
            new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 0}
        );
        System.out.println("Test Case 1: " + hasCycle(V1, edges1)); // true

        // Test Case 2
        int V4 = 5;
        List<int[]> edges4 = new ArrayList<>();
        System.out.println("Test Case 4: " + hasCycle(V4, edges4)); // false

        // Test Case 3
        int V5 = 3;
        List<int[]> edges5 = Arrays.asList(
            new int[]{0, 1}, new int[]{1, 0}
        );
        System.out.println("Test Case 5: " + hasCycle(V5, edges5)); // true
    }
}
