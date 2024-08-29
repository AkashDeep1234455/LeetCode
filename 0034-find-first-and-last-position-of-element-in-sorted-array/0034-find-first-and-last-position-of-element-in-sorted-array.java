class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] output = {-1,-1};
        
        int start = 0,end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                output[0] = mid;
                output[1] = mid;
                break;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        for(int i=output[0]+1;i<nums.length&&output[0]!=-1;i++){
            if(nums[i]==nums[output[0]]) output[1] = i;
            else break;
        }
        for(int i=output[0]-1;i>=0&&output[0]!=-1;i--){
            if(nums[i]==nums[output[1]]) output[0] = i;
            else break;
        }
        return output;
    }
}