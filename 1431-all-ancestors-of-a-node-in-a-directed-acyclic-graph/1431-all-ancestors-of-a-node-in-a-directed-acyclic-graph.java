class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
         List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int []edge:edges){
            graph.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topologicalSort(i, graph, visited, stack);
            }
        }

        // Step 2: Initialize ancestor sets
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        // Step 3: Process nodes in topological order
        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : graph.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));
            }
        }

        // Convert ancestor sets to sorted lists
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ancestorList = new ArrayList<>(ancestors.get(i));
            Collections.sort(ancestorList);
            result.add(ancestorList);
        }

        return result;
    }
     private void topologicalSort(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                topologicalSort(neighbor, graph, visited, stack);
            }
        }
        stack.push(node);
    }
}