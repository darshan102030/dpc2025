import java.util.*;

class ShortestPathFinder {

    public static int shortestPath(int V, List<int[]> edges, int start, int end) {
        // Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);  // Because the graph is undirected
        }

        // Edge case: start equals end
        if (start == end) return 0;

        // BFS setup
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[V];  // Stores distance from start

        // Start BFS from 'start' node
        visited[start] = true;
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);

                    if (neighbor == end) {
                        return distance[neighbor];
                    }
                }
            }
        }

        // No path found
        return -1;
    }

    public static void main(String[] args) {
        // Example 1
        int V1 = 5;
        List<int[]> edges1 = Arrays.asList(
            new int[]{0, 1},
            new int[]{0, 2},
            new int[]{1, 3},
            new int[]{2, 3},
            new int[]{3, 4}
        );
        System.out.println(shortestPath(V1, edges1, 0, 4)); // Output: 3

        // Example 2
        int V2 = 3;
        List<int[]> edges2 = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 2}
        );
        System.out.println(shortestPath(V2, edges2, 0, 2)); // Output: 2

        // Example 3
        int V3 = 4;
        List<int[]> edges3 = Arrays.asList(
            new int[]{0, 1},
            new int[]{1, 2}
        );
        System.out.println(shortestPath(V3, edges3, 2, 3)); // Output: -1
    }
}
