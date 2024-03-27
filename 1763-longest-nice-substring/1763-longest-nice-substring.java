class Solution {
    public String longestNiceSubstring(String s) {
        int left = 0;
        int right = 0;
        int size = s.length();
        String ans = "";
        for(int i=0;i<size;i++){
            HashMap<Character,Boolean> available = new HashMap<>();
            StringBuilder output = new StringBuilder();
            output.append(s.charAt(i));
            available.put(s.charAt(i),true);
            for(int j=i+1;j<size;j++){
                output.append(s.charAt(j));
                available.put(s.charAt(j),true);
                boolean ok =true;
                for(char key: available.keySet()){
                    if(Character.isUpperCase(key)){
                        if(!available.containsKey(Character.toLowerCase(key))){
                            ok = false;
                            break;
                        }
                    }else{
                        if(!available.containsKey(Character.toUpperCase(key))){
                            ok = false;
                            break;
                        }
                    }
                }
                if(ok&&output.length()>ans.length()){
                    ans= output.toString();
                }
            }
        }
        return ans;
    }
}