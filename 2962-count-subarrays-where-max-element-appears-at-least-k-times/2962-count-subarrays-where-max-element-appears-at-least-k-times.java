class Solution {
    public long countSubarrays(int[] nums, int k) {
        long length = nums.length;
        long ans = 0;
        long max = Integer.MIN_VALUE;
        for (int num:nums) {
            max = Math.max(num,max);
        }
        long totalSubArray = ((length)*(length+1))/2;
        long freqCheck=0;
        long tempAns  = 0;
        for(int right = 0,left = 0;right<length;right++){
            long value = nums[right];
            if(value==max) freqCheck++;
            while (left<=right&&freqCheck>=k){
                if(nums[left]==max) freqCheck--;
                left++;
            }
            tempAns+=(right-left+1);
        }
        return totalSubArray-tempAns;
    }
}