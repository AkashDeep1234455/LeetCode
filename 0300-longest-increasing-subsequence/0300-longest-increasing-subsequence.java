class Solution {
    public int lengthOfLIS(int[] nums) {
        int output[] = new int[nums.length];
        output[nums.length-1] = 0;
        for(int i=nums.length-2;i>=0;i--){
            int currNum = nums[i];
            for(int j=i+1;j<output.length;j++){
                if(nums[j]>currNum){
                    int curr = output[i];
                    int greaterNum = output[j];
                    output[i] = Math.max(curr,greaterNum+1);
                }
            }
        }
        int max = 0;
        for(int out:output){
            max = Math.max(max,out+1);
        }
        return max;
    }
}