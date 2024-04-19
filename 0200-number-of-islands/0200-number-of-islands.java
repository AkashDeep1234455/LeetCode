class Solution {
    static int[] xCoor = {1,0,-1,0};
    static int[] yCoor = {0,-1,0,1};
    public static void visitedMarker(char[][]grid,boolean[][] visited,int i,int j){
        if(grid[i][j]=='0') return; 
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int newX = i+xCoor[k];
            int newY = j+yCoor[k];
            if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length&&!visited[newX][newY]){
                visitedMarker(grid,visited,newX,newY);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int islandCount = 0;
        boolean[][] visited = new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    islandCount++;
                    visitedMarker(grid,visited,i,j);
                }
            }
        } 
        return islandCount;
    }
}