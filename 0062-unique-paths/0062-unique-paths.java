class Solution {
    public int uniquePaths(int m, int n) {
        int[][] output = new int[m][n];
        for(int i=0;i<m;i++) output[i][0] = 1;
        for(int i=0;i<n;i++) output[0][i] = 1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                output[i][j] = output[i-1][j]+output[i][j-1];
            }
        }
        return output[m-1][n-1];
    }
}