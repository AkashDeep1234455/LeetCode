class Solution {
    public int reversePairs(int[] nums) {
        if(nums.length==0||nums==null) return 0;
        return mergeSort(nums,0,nums.length-1);
    }
    public int mergeSort(int []nums,int left,int right){
        if(left>=right) return 0;
        int mid = left +(right-left)/2;
        int count = mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);

        ///counting
        int j = mid+1;
        for(int i=left;i<=mid;i++){
            while(j<=right&&(long)nums[i]>2L*nums[j]){
                j++;
            }
            count+=(j-mid-1);
        }
        merge(nums,left,mid,right);
        return count;
    }
    public void merge(int[]nums,int left,int mid,int right){
        int temp[] = new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while(i<=mid&&j<=right){
            if(nums[i]>nums[j]){
                temp[k++] =nums[j++];
            }else{
                temp[k++] = nums[i++];
            }
        }
        while(j<=right) temp[k++] =nums[j++];
        while(i<=mid) temp[k++] =nums[i++];
        System.arraycopy(temp,0,nums,left,temp.length);
    }
}