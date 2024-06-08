class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
          int length = nums.length;
        int[] prefixSum = new int[length];
        prefixSum[0] = nums[0];
        for(int i=1;i<length;i++){
            if(nums[i]==0&&nums[i-1]==0) return true;
            prefixSum[i] = prefixSum[i-1]+nums[i];
            if(prefixSum[i]>0&&prefixSum[i]%k==0) return true;
            for(int j=0;i-j>1;j++){
                if(prefixSum[i]-prefixSum[j]<k) break;
                if((prefixSum[i]-prefixSum[j])%k==0) return true;
            }
        }
        return false;
    }
}