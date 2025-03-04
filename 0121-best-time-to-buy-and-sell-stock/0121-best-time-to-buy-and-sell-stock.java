class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;
        int sell=0;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[buy]>prices[i]){
                buy=i;
            }
            if(prices[sell]<prices[i]){
                sell=i;
            }
            if(sell<buy) sell=buy;
            if(prices[sell]-prices[buy]>profit){
                profit = prices[sell]-prices[buy];
            }
        }
        return profit;
    }
}