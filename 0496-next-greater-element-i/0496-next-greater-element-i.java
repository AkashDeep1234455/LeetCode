class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] output = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            int curr = nums2[i];
            while(!stack.isEmpty()&&stack.peek()<curr){
                map.put(stack.pop(),curr);
            }
            stack.push(curr);
        }
        int index = 0;
        for(int num1:nums1){
            if(map.containsKey(num1)){
                output[index++] = map.get(num1);
            }else{
                output[index++] = -1;
            }
        }
        return output;
    }
}