class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         int map[] = new int[k];
        int sum = 0,output = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder = sum%k;
            if(remainder==0) output++;
            if(remainder<0) remainder+=k;
            if(map[remainder]!=0){
                output+=map[remainder];
            }
           map[remainder]++;
        }
        return output;
    }
}