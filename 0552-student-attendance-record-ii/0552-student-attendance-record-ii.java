class Solution {
    static int mod = 1000000007;
    public int checkRecord(int n) {
        int dp[][][] = new int[n+1][2][3];
        dp[0][0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int a=0;a<2;a++){
                for(int l=0;l<3;l++){
                    dp[i][a][0] =(dp[i][a][0]+dp[i-1][a][l])%mod;
                    if(a>0){
                        dp[i][a][0] =(dp[i][a][0]+dp[i-1][a-1][l])%mod;
                    }
                    if(l>0){
                        dp[i][a][l] = (dp[i][a][l]+dp[i-1][a][l-1])%mod;
                    }
                }
            }
        }
        int result = 0;
        for(int a=0;a<2;a++){
            for(int l=0;l<3;l++){
                result=(result+dp[n][a][l])%mod;
            }
        }
        return result;
    }
}