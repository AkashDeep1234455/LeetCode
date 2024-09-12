class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean allow[] = new boolean[26];
        for(int i=0;i<allowed.length();i++){
            int index = allowed.charAt(i) - 'a';
            allow[index] = true;
        }
        int out = 0;
        for(String word:words){
        boolean check = true;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(!allow[index]) {
                    check = false;
                    break;
                }
            }
            if(check) out++;
        }
        return out;
    }
}