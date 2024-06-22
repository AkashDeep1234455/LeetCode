class Solution {
    public static int numberOfSubarraysHelper(int[]nums,int k){
        int sum = 0;
        int count = 0;
        for(int right = 0,left = 0;right<nums.length;right++){
            sum+=nums[right];
            while (sum>k&&left<=right){
                sum-=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
          for(int i=0;i<nums.length;i++){
           if(nums[i]%2==0) nums[i] = 0;
           else nums[i] = 1;
       }
       return numberOfSubarraysHelper(nums,k)-numberOfSubarraysHelper(nums,k-1);
    }
}