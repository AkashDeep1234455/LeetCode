class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int value = nums[i];
            if(value>n||value<=0){
                nums[i] = n+1;
            }
        }
        for(int i=0;i<nums.length;i++){
            int value= Math.abs(nums[i]);
            if(value-1<nums.length) {
                if(nums[value-1]>0) {
                    nums[value - 1] *= -1;
                }
            }
        }
        int ans = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans = i+1;
                break;
            }
        }
        if(ans==-1) return n+1;
        return ans;
    }
}