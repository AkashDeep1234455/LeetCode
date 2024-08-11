class Solution {
    public int findPeakElement(int[] nums) {
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                return i;
            }
        }
        int max = Integer.MIN_VALUE;
            int out = 0;
            for(int i=0;i<nums.length;i++){
                if(max<nums[i]){
                    max = nums[i];
                    out = i;
                }
            }
        return out;
    }
}