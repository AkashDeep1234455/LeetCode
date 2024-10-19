class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    private int helper(int amount,int[] coins,int[]dp){
        if(amount<0) return Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount]; 
        int max = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int number = helper(amount-coins[i],coins,dp);
            if(number!=Integer.MAX_VALUE){
                max = Math.min(max,1+number);
            }
        }
        dp[amount] = max;
        return max;
    }
}