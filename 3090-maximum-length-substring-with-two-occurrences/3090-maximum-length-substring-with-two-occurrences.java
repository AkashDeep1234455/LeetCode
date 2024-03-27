class Solution {
    public int maximumLengthSubstring(String s) {
        int ans=0;
        int left = 0;
        int right = 0;
        int size = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        while(right!=size){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)>2){
                while(map.get(c)!=2){
                    char ch = s.charAt(left);
                    map.put(ch,map.get(ch)-1);
                    left++;
                }
            }
            if(right-left+1>ans){
                ans=right-left+1;
            }
            right++;
        }
        return ans;
    }
}