class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return helper(n,0,map);
    }
    private int helper(int n,int currStep,HashMap<Integer,Integer> map){
        if(currStep>n) return 0;
        if(currStep==n){
            return 1;
        }
        if(map.containsKey(currStep)){
           return map.get(currStep);
        }
        int result = helper(n,currStep+1,map)+helper(n,currStep+2,map);
        map.put(currStep,result);
        return result;
    }
}