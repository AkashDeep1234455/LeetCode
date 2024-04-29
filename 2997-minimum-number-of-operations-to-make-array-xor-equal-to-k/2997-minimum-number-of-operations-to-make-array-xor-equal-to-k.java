class Solution {
    public int minOperations(int[] nums, int k) {
        int totalXOR = nums[0];
        for(int i=1;i<nums.length;i++) totalXOR = totalXOR^nums[i];
        if(totalXOR==k) return 0;

        int diffXOR = totalXOR^k;
        int count = 0;
        while (diffXOR!=0){
            if((diffXOR&1)==1) count++;
           diffXOR =  diffXOR>>1;
        }
        return count;
    }
}