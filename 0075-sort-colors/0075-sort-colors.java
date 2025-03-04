class Solution {
    public void sortColors(int[] nums) {
        int zero=0,one=0,two=0;
        for(int num:nums){
            if(num==0) zero++;
            else if(num==1) one++;
            else two++;
        }
        int i=0;
        while(one!=0||two!=0||zero!=0){
            if(zero!=0){
                nums[i] = 0;
                zero--;
            }else if(one!=0){
                nums[i] = 1;
                one--;
            }else{
                nums[i] = 2;
                two--;
            }
            i++;
        }
        
    }
}