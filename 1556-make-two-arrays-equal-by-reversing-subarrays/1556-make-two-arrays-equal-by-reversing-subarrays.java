class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(arr.length!=target.length) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int tar:target){
            map.put(tar,map.getOrDefault(tar,0)+1);
        }
        for(int ar:arr){
            if(!map.containsKey(ar)||map.get(ar)==0) return false;
            else{
                map.put(ar,map.get(ar)-1);
            }
        }
        return true;
    }
}