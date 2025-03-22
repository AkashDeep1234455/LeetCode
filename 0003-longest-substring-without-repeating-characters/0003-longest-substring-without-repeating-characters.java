class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0;
        int length = 0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                start = Math.max(start,map.get(curr));
            }
            length = Math.max(length,i-start+1);
            map.put(curr,i+1);
        }
        return length;
    }
}