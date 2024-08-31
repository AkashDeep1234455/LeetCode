class Solution {
    public int maxSubArray(int[] nums) {
        int sum =0;
        int max=nums[0];
        for(int num:nums){
            sum+=num;
            max = (max<sum)?sum:max;
            if(sum<0) sum = 0;
        }
        return max;
    }
}