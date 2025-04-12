class Solution {
    public boolean check(char[][]board,int x,int y,char num){
        ///row check
        for(int j=0;j<9;j++) if(board[x][j]==num) return false;

        ///col check
        for(int i=0;i<9;i++) if(board[i][y]==num) return false;

        ///sub box check
        int xIndex = x/3;
        int yIndex  =y/3;
        
        int xStart=3*xIndex;
        int xEnd=3*(xIndex+1);
        int yStart=3*yIndex;
        int yEnd = 3*(yIndex+1);

        for(int i=xStart;i<xEnd;i++){
            for(int j=yStart;j<yEnd;j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
    public boolean helper(char board[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(check(board,i,j,c)){
                            board[i][j] = c;
                            if(helper(board)) return true;
                            else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        helper(board);
    }
}