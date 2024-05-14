class Solution {
        public static int maxGoldFinder(int[][]grid,int x,int y,int row,int column,boolean visited[][]){
        if(x<0||x>=row||y<0||y>=column||grid[x][y]==0||visited[x][y]) return 0;
        visited[x][y] = true;
        int option1 = grid[x][y] + maxGoldFinder(grid,x+1,y,row,column,visited);
        int option2 = grid[x][y] + maxGoldFinder(grid,x,y+1,row,column,visited);
        int option3 = grid[x][y] + maxGoldFinder(grid,x-1,y,row,column,visited);
        int option4 = grid[x][y] + maxGoldFinder(grid,x,y-1,row,column,visited);
        visited[x][y] = false;
        return Math.max(option1,Math.max(option2,Math.max(option3,option4)));
    }
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean visited[][] = new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]!=0){
                    int currGold = maxGoldFinder(grid,i,j,row,column,visited);
                    if(currGold>maxGold) maxGold = currGold;
                }
            }
        }
        return maxGold;
    }
}