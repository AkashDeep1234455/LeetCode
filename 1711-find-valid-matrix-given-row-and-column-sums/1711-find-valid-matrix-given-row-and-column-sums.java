class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int output[][] = new int[rowSum.length][colSum.length];
        for(int i=0;i<rowSum.length;i++){
            for(int j=0;j<colSum.length;j++){
                int minSum = Math.min(rowSum[i], colSum[j]);
                output[i][j] = minSum;
                rowSum[i] -= minSum;
                colSum[j] -= minSum;
            }
        }
        return output;
    }
}