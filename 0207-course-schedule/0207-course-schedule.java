class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean completed[] = new boolean[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int []prerequisite:prerequisites){
            int first = prerequisite[0];
            int second = prerequisite[1];
            if(map.containsKey(first)){
                List<Integer> depend = map.get(first);
                depend.add(second);
            }else{
                List<Integer> depend = new LinkedList<>();
                depend.add(second);
                map.put(first,depend);
            }
        }
        for(int i=0;i<numCourses;i++){
            boolean visited[] = new boolean[numCourses];
            if(!completed[i]){
                boolean ans = helper(i,map,completed,visited);
                System.out.println(ans);
                completed[i] = ans;
                if(!ans) return false;
            }
        }
        return true;
    }
    public boolean helper(int course,HashMap<Integer,List<Integer>>map,boolean[] completed,boolean visited[]){
        if(!map.containsKey(course)||completed[course]){
            return true;
        }
        if(visited[course]) return false;
        visited[course] = true;
        List<Integer> depend = map.get(course);
        for(int i=0;i<depend.size();i++){
            int val = depend.get(i);
            boolean ans = helper(val,map,completed,visited);
            if(ans) completed[val] = true;
            if(!ans) return false;
        }
        return true;
        
    }
}