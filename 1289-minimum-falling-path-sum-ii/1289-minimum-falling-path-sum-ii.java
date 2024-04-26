class Solution {
    public int minFallingPathSum(int[][] grid) {
         int n =grid.length;
        int [][]pathLengthStore = new int[n][n];

        ///initiallising first row of 2d array......
        for(int i=0,j=0;j<n;j++) pathLengthStore[i][j] = grid[i][j];

        ///MinPath Finding for other rows
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                Queue<Integer> sum = new LinkedList<>();
                int currSum = grid[i][j];
                for(int k=0;k<n;k++){
                    if(k!=j){
                        currSum+=pathLengthStore[i-1][k];
                        sum.add(currSum);
                        currSum-=pathLengthStore[i-1][k];
                    }
                }
                int min = Integer.MAX_VALUE;
                while (!sum.isEmpty()){
                    int top = sum.poll();
                   if(min>top) min = top;
                }
                pathLengthStore[i][j] = min;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=n-1,j=0;j<n;j++){
            if(min>pathLengthStore[i][j]) min = pathLengthStore[i][j];
        }
        return min;
    }
}