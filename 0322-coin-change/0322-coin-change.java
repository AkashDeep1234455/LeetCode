class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        int result = helper(amount,coins, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
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