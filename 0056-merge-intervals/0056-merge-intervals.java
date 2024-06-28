class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int output[][] = new int[intervals.length][2];
        output[0] = intervals[0];
        int prev[] = output[0];
        int index = 1;
        int prevIndex = 0;
        for(int i=1;i<intervals.length;i++){
             int curr[] = intervals[i];
             if(prev[1]>=curr[0]){
                 if(curr[1]>prev[1]) {
                     prev = new int[]{prev[0], curr[1]};
                     output[prevIndex] = prev;
                 }else{
                     prev = new int[]{prev[0], prev[1]};
                     output[prevIndex] = prev;
                 }
             }else{
                 output[index] = curr;
                 prev  = curr;
                 prevIndex = index;
                 index++;
             }
        }
        return Arrays.copyOf(output,index);
    }
}