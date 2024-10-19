class Solution {
    public int climbStairs(int n) {
        int output[] = new int[n+1];
        output[1] = 1;
        if(n>1){
            output[2] =  2;
        }
        for(int i=3;i<=n;i++){
            output[i] = output[i-1]+output[i-2];
        }
        return output[n];
    }
}