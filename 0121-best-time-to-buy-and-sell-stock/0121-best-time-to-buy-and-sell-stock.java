class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        int output = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                int profit = prices[i]-min;
                output = Math.max(output,profit);
            }else if(prices[i]<min){
                min = prices[i];
            }
        }
        return output;
    }
}