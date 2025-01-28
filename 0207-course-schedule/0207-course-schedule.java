class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
        graph.putIfAbsent(prerequisite[0], new ArrayList<>()); 
        graph.get(prerequisite[0]).add(prerequisite[1]); 
    }
        int visited[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
            if(cycle(i,graph,visited)) return false;
            }
        }
        return true;
    }
    public boolean cycle(int start, HashMap<Integer,ArrayList<Integer>> graph,int[] visited){
        if(visited[start]==1) return true;
        if(visited[start]==2) return false;
        visited[start] = 1;
        if(graph.containsKey(start)){
            ArrayList<Integer> nexts = graph.get(start);
            for(int next:nexts){
                if(cycle(next,graph,visited)) return true;
            }
        }
        visited[start] = 2;
        return false;
    }
}