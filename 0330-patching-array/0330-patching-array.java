class Solution {
    public int minPatches(int[] nums, int n) {
        long sum = 0;
        long nextNum = 1;
        int patch = 0;
        int i=0;
        while (sum<n){
            if(i<nums.length&&nums[i]<=nextNum){
                sum+=nums[i];
                i++;
            }else{
                sum+=nextNum;
                patch++;
            }
            nextNum = sum+1;
        }
        return patch;
    }
}