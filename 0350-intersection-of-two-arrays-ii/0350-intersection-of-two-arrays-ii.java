class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int size= nums1.length>nums2.length?(nums2.length):nums1.length;
        int output[] = new int[size];
        int index = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
        for(int i=0;i<nums1.length;i++){
            int curr = nums1[i];
            if(map.containsKey(curr)){
                int val = map.get(curr);
                if(val!=0){
                    output[index] = curr;
                    map.put(curr,val-1);
                    index++;
                }
            }
        }
        return Arrays.copyOfRange(output,0,index);
    }
}