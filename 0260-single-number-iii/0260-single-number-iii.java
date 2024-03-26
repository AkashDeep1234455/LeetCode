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
        Queue<Integer> divided = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            int number = nums[i];
            number = number>>position;
            if((number&1)==1){
                divided.add(nums[i]);
            }
        }
        int newCopy = result;
        int size = divided.size();
        for(int i = 0;i<size;i++){
            result = result^divided.poll();
        }
        ans[0] = result;
        ans[1] = newCopy^result;
        return ans;
    }
}