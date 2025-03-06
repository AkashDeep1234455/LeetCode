class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int merged[] = new int[m+n];
        int s1=0,s2=0;
        for(int i=0;i<m+n;i++){
            if(s1==m){
                merged[i] = nums2[s2++];
            }else if(s2==n){
                merged[i] = nums1[s1++];
            }else if(nums1[s1]<nums2[s2]){
                merged[i] = nums1[s1++];
            }else{
                merged[i] = nums2[s2++];
            }
        }
        for(int i=0;i<m+n;i++){
            nums1[i] = merged[i];
        }

    }
}