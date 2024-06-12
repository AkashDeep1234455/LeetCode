class Solution {
    public void sortColors(int[] nums) {
        int [] color = new int[3];
        for(int i=0;i<nums.length;i++){
            color[nums[i]]++;
        }
        int index = 0;
        for(int i=0;i<3;i++){
            int curr = color[i];
            for(int j=0;j<curr;j++){
                nums[index] = i;
                index++;
            }
        }
    }
}