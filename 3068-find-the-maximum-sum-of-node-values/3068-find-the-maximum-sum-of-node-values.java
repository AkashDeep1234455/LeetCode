class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long length = nums.length;
        long totalSum =0;
        for(int num:nums){
            totalSum+=num;
        }
        long totaldiff=0;
        long positive_count = 0;
        long min_abs_diff = Long.MAX_VALUE;
        for(int i=0;i<length;i++){
            long xor = nums[i]^k;
            long diff = xor-nums[i];
            if(diff>0){
                totaldiff+=diff;
                positive_count++;
            }
            min_abs_diff = Math.min(min_abs_diff,Math.abs(diff));
        }
        if(positive_count%2==1) totaldiff-= min_abs_diff;
        return totalSum+totaldiff;
    }
}