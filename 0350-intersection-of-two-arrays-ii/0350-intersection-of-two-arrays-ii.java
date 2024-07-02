class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
        for(int i=0;i<nums1.length;i++){
            int curr = nums1[i];
            if(map.containsKey(curr)){
                int val = map.get(curr);
                if(val!=0){
                    list.add(curr);
                    map.put(curr,val-1);
                }
            }
        }
        int out[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            out[i] = list.get(i);
        }
        return out;
    }
}