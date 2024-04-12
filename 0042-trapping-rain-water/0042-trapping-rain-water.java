class Solution {
    public int trap(int[] heights) {
           int right = 0;
        int left = heights.length-1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
int waterStored = 0;
        while(right<left){
            if(heights[right]>=heights[left]){
                if(heights[left]>leftMax){
                    leftMax = heights[left];
                }else{
                    waterStored +=leftMax-heights[left];
                }
                left--;
            }else{
                if(heights[right]>rightMax){
                    rightMax = heights[right];
                }else{
                    waterStored+=rightMax-heights[right];
                }
                right++;
            }
        }
        return waterStored;
    }
}