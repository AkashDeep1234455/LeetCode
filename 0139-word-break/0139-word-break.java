class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        HashMap<Integer,Boolean> map = new HashMap<>();
        for(String word:wordDict) set.add(word);
        return helper(s,new StringBuilder(),set,0,map);
    }
    private boolean helper(String s,StringBuilder input,HashSet<String> set,int start,HashMap<Integer,Boolean> map ){
        if(s.length()==start) return true;
        if(map.containsKey(start)) return map.get(start);
        for(int i=start;i<s.length();i++){
            input.append(s.charAt(i));
            if(set.contains(input.toString())){
                if(helper(s,new StringBuilder(),set,i+1,map)) {
                    map.put(start,true);
                    return true;
                }
            }
        }
        map.put(start,false);
        return false;
    }
}