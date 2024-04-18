class Solution {
    static int[] xCoor = {1,0,-1,0};
    static int[] yCoor = {0,-1,0,1};
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean visited[][] = new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]==1){
                    int count = 0;
                     for(int k=0;k<4;k++){
                         int newX=i+xCoor[k];
                         int newY=j+yCoor[k];
                         if(newX>=0&&newX<row&&newY>=0&&newY<column){
                             if(grid[newX][newY]==1) count++;
                         }
                     }                                   
                    perimeter = perimeter+4-count;  
                }
            }
        }
        return perimeter;
    }
}