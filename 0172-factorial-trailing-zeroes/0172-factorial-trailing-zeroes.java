class Solution {
    public int trailingZeroes(int n) {
        int output = 0;
        while(n>0){
            n = n/5;
            output+=n;
        }
        return output;
    }
}