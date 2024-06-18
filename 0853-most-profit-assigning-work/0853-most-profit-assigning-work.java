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
        int currProfit =0;
        Arrays.sort(worker);
        int j=0;
        for(int i=0;i<worker.length;i++){
            int workCapacity = worker[i];
            while (j<jobs.length&&workCapacity>=jobs[j][0]){
                currProfit = Math.max(currProfit,jobs[j][1]);
                j++;
            }
            totalProfit+=currProfit;
        }
        return totalProfit;
    }
}