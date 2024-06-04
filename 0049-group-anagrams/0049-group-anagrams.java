class Solution {
     public static boolean checkAnagram(String first,String curr){
        HashMap<Character,Integer> map = new HashMap<>();
        if(first.length()!=curr.length()) return false;
        for(int i=0;i<first.length();i++){
            map.put(first.charAt(i),map.getOrDefault(first.charAt(i),0)+1);
        }
        for(int i=0;i<curr.length();i++){
            char c = curr.charAt(i);
            if(map.containsKey(c)&&map.get(c)!=0){
                map.put(c,map.get(c)-1);
            }else{
                return false;
            }
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outputs = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            String curr = strs[i];
            boolean added = false;
            for(List<String> output : outputs ){
                String first = output.get(0);
                if(checkAnagram(first,curr)){
                    output.add(curr);
                    added = true;
                    break;
                }
            }
            if(!added){
                List<String> newEntry = new ArrayList<>();
                newEntry.add(curr);
                outputs.add(newEntry);
            }
        }
        return outputs;
    }
}