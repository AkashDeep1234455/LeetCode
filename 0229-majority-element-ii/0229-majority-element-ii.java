class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> output = new LinkedList<>();
        int n = nums.length;
        int requiredFrequency = n/3;
///candidate 1
        int candidate1 =-1,count1=0,candidate2=-1,count2=0;
        for(int num:nums){
            if(num==candidate1) count1++;
            else if(num==candidate2) count2++;
            else if(count1==0) {
                candidate1=num;
                count1=1;
            }
            else if(count2==0) {
                candidate2=num;
                count2=1;
            }else{
                count1--;
                count2--;
            }

        }
        count1=count2 =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==candidate1) count1++;
            else if(nums[i]==candidate2) count2++;
        }
        if(count1>requiredFrequency) output.add(candidate1);
        if(count2>requiredFrequency) output.add(candidate2);
    
        return output;
    }
}