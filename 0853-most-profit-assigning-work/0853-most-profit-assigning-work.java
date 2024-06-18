class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int totalProfit = 0;
        for(int i=0;i<worker.length;i++){
            int currProfit = 0;
            int workerCapacity = worker[i];
            for(int j=0;j<difficulty.length;j++){
                if(difficulty[j]<=workerCapacity){
                    currProfit = Math.max(currProfit,profit[j]);
                }
            }
            totalProfit+=currProfit;
        }
        return totalProfit;
    }
}