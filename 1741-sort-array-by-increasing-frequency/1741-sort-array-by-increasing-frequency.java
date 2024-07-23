class Solution {
    public int[] frequencySort(int[] nums) {
        int arr[] = new int[201];
        for(int i=0;i<nums.length;i++){
            int currNum = nums[i];
            if(currNum>=0){
                arr[currNum] = arr[currNum]+1;
            }else{
                int index = 100+Math.abs(nums[i]);
                arr[index] = arr[index]+1;
            }
        }
        int output[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int j=0;j<201;j++){
                if(arr[j]<min&&arr[j]!=0){
                    min = arr[j];
                    index = j;
                }else if(arr[j]==min&&arr[j]!=0){
                    if(index<=100&&j>100) continue;
                    else if(index>100&&j>100) continue;
                    else{
                        min = arr[j];
                        index = j;
                    }
                }
            }
            for(;i<nums.length&&min>0;i++){
                if(index<=100){
                output[i] = index;
                min--;
                arr[index] = 0;
                }else{
                    output[i] = -(index-100);
                    min--;
                    arr[index] = 0;
                }
            }
            i--;
        }
        return output;
    }
}