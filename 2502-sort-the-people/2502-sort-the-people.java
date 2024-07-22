class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] output = new String[names.length];
        for(int i=0;i<heights.length;i++){
            pq.add(heights[i]);
        }
        int index = heights.length-1;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            output[index] = map.get(curr);
            index--;
        }
        return output;
    }
}