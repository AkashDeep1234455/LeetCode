class Solution {
    public int[] singleNumber(int[] nums) {
        int ans[] = new int[2];
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result = result^nums[i];
        }
        int position =0;
        int resultCopy = result;
        while(true){
            if((resultCopy&1)==1){
                break;
            }
            resultCopy=resultCopy>>1;
            position++;
        }
       
        ans[0] = 0;
        ans[1] = 0;
        for(int i=0;i<nums.length;i++){
            int number= nums[i];
            number = number>>position;
            if((number&1)!=0){
                arr[0]^=nums[i];
            }
        }
        arr[1] = arr[0]^result;
            
            return ans;
    }
}
