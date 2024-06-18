class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int n = difficulty.length;
        int [][] jobs = new int[n][2];
        for(int i=0;i<n;i++){
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs,(a,b)->Integer.compare(a[0],b[0]));
        int totalProfit = 0;
        for(int i=0;i<worker.length;i++){
            int workCapacity = worker[i];
            int currProfit = 0;
            for(int j=0;j<jobs.length;j++){
                if(jobs[j][0]>workCapacity) break;
                currProfit = Math.max(currProfit,jobs[j][1]);
            }
            totalProfit+=currProfit;
        }
        return totalProfit;
    }
}