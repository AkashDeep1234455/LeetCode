class Solution {
    public static boolean magicChecker(int[][]grid,int rStart,int cStart){
        HashSet<Integer> set = new HashSet<>();
        for(int i=rStart;i<=rStart+2;i++){
            for(int j=cStart;j<=cStart+2;j++){
                int curr = grid[i][j];
                if(curr<1||curr>9) return false;
                if(set.contains(curr)) return false;
                set.add(curr);
            }
        }


        int diagonalSum = grid[rStart][cStart]+grid[rStart+1][cStart+1]+grid[rStart+2][cStart+2];
        int diagonalSum2 = grid[rStart][cStart+2]+grid[rStart+1][cStart+1]+grid[rStart+2][cStart];
        if(diagonalSum!=diagonalSum2) return false;

        for(int i=rStart;i<=rStart+2;i++){
            int sum = 0;
            for(int j=cStart;j<=cStart+2;j++){
                sum+=grid[i][j];
            }
            if(sum!=diagonalSum) return false;
        }
         for(int i=cStart;i<=cStart+2;i++){
            int sum = 0;
            for(int j=rStart;j<=rStart+2;j++){
                sum+=grid[j][i];
            }
            if(sum!=diagonalSum) return false;
        }
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length<3||grid[0].length<3) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int output = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int rStart=i,cStart=j,rEnd=i+2,cEnd=j+2;
                if(rEnd>=row||cEnd>=col) break;
                if(magicChecker(grid,rStart,cStart)){
                    output++;
                }
            }
        }
        return output;
        
    }
}