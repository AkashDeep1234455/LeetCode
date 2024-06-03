class Solution {
    public int appendCharacters(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        int tIndex = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<slength;i++){
            if(tIndex<tlength&&s.charAt(i)==t.charAt(tIndex)){
                tIndex++;
            }
        }
        return tlength-tIndex;
    }
}