class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int product =nums[i];
            if(product<k) count++;
            for(int j=i+1;j<n;j++){
                product*=nums[j];
                if(product<k) count++;
                if(product>=k) break;
            }
        }
        return count;
    }
}