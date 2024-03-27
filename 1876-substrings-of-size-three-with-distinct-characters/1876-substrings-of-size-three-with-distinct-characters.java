class Solution {
    public int countGoodSubstrings(String s) {
        
        int left = 0;
        int right = 2;
        int size = s.length();
        if(size<3) return 0;
        int count = 0;
        while(right!=size){
            HashMap<Character,Boolean> map = new HashMap<>();
            boolean repeat = false;
            for(int i=left;i<=right;i++){
                char c= s.charAt(i);
                if(!map.containsKey(c)){
                    map.put(c,true);
                }else{
                    repeat = true;
                }
            }
            if(!repeat) count++;
            left++;
            right++;
        }
        return count;
    }
}