class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int num:nums){
            nums[num%n]+=n;
        }
        int result = 0;
        for(int i=0;i<n;i++){
            if(nums[i]/n>=2){
                result=i;
                break;
            }
        }
        return result;
    }
}