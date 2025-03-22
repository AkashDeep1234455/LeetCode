class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int trappedWater = 0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax = height[left];
                }else{
                    trappedWater += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right]>rightMax){
                    rightMax = height[right];
                }else{
                    trappedWater += rightMax-height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}