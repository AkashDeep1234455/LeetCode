class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int output[] = new int[n];
        output[0] = nums[0];
        int max = output[0];
        for(int i=1;i<n;i++){
            if(i==1){
                max = Math.max(max,nums[1]);
            }else{
                max = Math.max(max,nums[i]+output[i-2]);
            }
            output[i] = max;
        }
        return output[n-1];
    }
}