class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
   for(int i=s.length()-1;i>=0;i--){
       if(s.charAt(i)!=' '){
           count++;
       }
       if(i!=s.length()-1&&s.charAt(i)==' '&&s.charAt(i+1)!=' '){
           return count;
       }
   }
    return count;
    }
}