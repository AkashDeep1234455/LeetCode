class Solution {
    public int findCenter(int[][] edges) {
        int size = edges.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<size;i++){
            int curr[] = edges[i];
            map.put(curr[0],map.getOrDefault(curr[0],0)+1);
            map.put(curr[1],map.getOrDefault(curr[1],0)+1);
        }
        int output = 0;
        for(int key:map.keySet()){
             if(output<map.get(key)) output = key;
        }
        return output;
    }
}