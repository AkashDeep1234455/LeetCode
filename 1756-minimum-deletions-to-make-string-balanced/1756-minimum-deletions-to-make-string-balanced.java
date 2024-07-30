class Solution {
    public int minimumDeletions(String s) {
        int deletion = 0;
        int countB = 0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr=='b') countB++;
            else{
                if(countB>0){
                    deletion +=1;
                    countB-=1;
                }
            }
        }
        return deletion;
    }
}