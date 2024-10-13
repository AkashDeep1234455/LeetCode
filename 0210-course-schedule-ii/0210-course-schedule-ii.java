class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean completed[] = new boolean[numCourses];
        Stack<Integer> sequence = new Stack<>();
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
                boolean ans = helper(i,map,completed,visited,new int[1],sequence);
                if(!ans) return new int[0];
            }
        }
        int output[] = new int[numCourses];
        int index = numCourses-1;
        while(!sequence.isEmpty()){
            output[index] = sequence.pop();
            index--;
        }
        return output;
    }
    public boolean helper(int course,HashMap<Integer,List<Integer>>map,boolean[] completed,boolean visited[],int count[],Stack<Integer> sequence){
        if(completed[course]){
            return true;
        }
        if(visited[course]) return false;
        visited[course] = true;
        if(map.containsKey(course)){
             List<Integer> depend = map.get(course);
        for(int i=0;i<depend.size();i++){
            int val = depend.get(i);
            boolean ans = helper(val,map,completed,visited,count,sequence);
            if(!ans) return false;
        }
        }
        completed[course] = true;
        sequence.push(course);
        return true;
    }
}
 