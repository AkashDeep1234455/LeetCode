class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
          if (n == 1) return Collections.singletonList(0);
        int lengthOfEdge = edges.length;

        /////Adjacency List Created
        HashMap<Integer,List<Integer>> adjacencyList = new HashMap<>();
        int degree[] = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adjacencyList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        ////Building Trees
        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }
        int total = n;
        while (n>2){
            n-=leaves.size();
            Queue<Integer> newLeaves = new LinkedList<>();
            int size = leaves.size();
            for(int i=0;i<size;i++){
                int leaf = leaves.poll();
                for(int neighbour:adjacencyList.get(leaf)){
                    degree[neighbour]--;
                    if(degree[neighbour]==1) newLeaves.add(neighbour);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }
}