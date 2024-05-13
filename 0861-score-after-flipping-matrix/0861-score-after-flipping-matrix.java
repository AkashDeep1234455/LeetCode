class Solution {
    public static void flipRow(int[][] grid,int row){
        int noOfColumn = grid[0].length;
        for(int j=0;j<noOfColumn;j++){
            if(grid[row][j]==0) grid[row][j] = 1;
            else grid[row][j] = 0;
        }
    }
    public static void flipColumn(int[][] grid,int column){
        int noOfrow = grid.length;
        for(int i=0;i<noOfrow;i++){
            if(grid[i][column]==0) grid[i][column] = 1;
            else grid[i][column] = 0;
        }
    }

    public static boolean countComp(int [][]grid,int column){
        int zeroCount = 0,oneCount = 0;
        for(int i=0;i<grid.length;i++){
            if(grid[i][column]==1) oneCount++;
            else zeroCount++;
        }
        return oneCount>zeroCount;
    }
    public int matrixScore(int[][] grid) {
         int rowCOunt = grid.length;
        int colCount = grid[0].length;
        for(int i=0;i<rowCOunt;i++){
            if(grid[i][0]==0) flipRow(grid,i);
        }
        for(int j=0;j<colCount;j++){
            if(!countComp(grid,j)) flipColumn(grid,j);
        }
        int outputSum = 0;
        for(int i=0;i<rowCOunt;i++){
            StringBuilder curr = new StringBuilder();
            for(int j=0;j<colCount;j++){
                curr.append(grid[i][j]);
            }
            int out = Integer.parseInt(curr.toString(),2);
            outputSum+=out;
        }
        return outputSum;
    }
}