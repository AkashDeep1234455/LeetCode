class Solution {
    public int longestPalindrome(String s) {
        int size = s.length();
        int map[] = new int[200];
        for(int i=0;i<size;i++){
            char c = s.charAt(i);
            map[c]++;
        }
        boolean one = false;
        int output = 0;
        for(int i=0;i<size;i++){
            char c = s.charAt(i);
            if(map[c]==1&&!one) {
                output++;
                one = true;
                map[c] = 0;
            }
            if(map[c]%2==0){
                output+=map[c];
                map[c] = 0;
            }else if (map[c]%2!=0&&map[c]!=1){
                output=output+map[c]-1;
                map[c] = 1;
            }
        }
        return output;
    }
}