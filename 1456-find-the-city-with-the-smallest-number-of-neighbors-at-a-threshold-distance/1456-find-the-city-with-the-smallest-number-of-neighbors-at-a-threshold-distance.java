class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        // Initialize the distance matrix with a large value (representing infinity)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE / 2; // Use /2 to avoid overflow during addition
                }
            }
        }

        // Populate the distance matrix with edge weights
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        // Floyd-Warshall algorithm to compute shortest paths between all pairs of nodes
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int[] reachableCities = new int[n];
        int minReachable = Integer.MAX_VALUE;
        int city = -1;

        // Count the number of reachable cities within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities[i]++;
                }
            }
        }

        // Find the city with the smallest number of reachable cities (and highest index in case of tie)
        for (int i = 0; i < n; i++) {
            if (reachableCities[i] < minReachable || (reachableCities[i] == minReachable && i > city)) {
                minReachable = reachableCities[i];
                city = i;
            }
        }

        return city;
    }

}
