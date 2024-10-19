class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for(String word:wordDict) set.add(word);
        boolean output[] = new boolean[n+1];
        output[n] =true; 
        for(int i=n-1;i>=0;i--){
            StringBuilder input = new StringBuilder();
            for(int j=i;j<n;j++){
                input.append(s.charAt(j));
                if(set.contains(input.toString())&&output[j+1]){
                    output[i] = true;
                    break;
                }
            }
        }
        return output[0];
    }
}