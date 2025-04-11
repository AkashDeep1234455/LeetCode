class Solution {

    public boolean queenChecker(char [][]board,int i,int j){
        int n = board.length;
        ///forward horizontal check
        // for(int y=j+1;y<n;y++){
        //     if(board[i][y]=='Q') return true;
        // }
        // ///backward horizontal check
        // for(int y=0;y<j;y++){
        //     if(board[i][y]=='Q') return true;
        // }
        ///upward check
        for(int x=i-1;x>=0;x--){
            if(board[x][j]=='Q') return true;
        }
        ////backward diagonal check
        int x = i-1;
        int y = j-1;
        while(x>=0&&y>=0){
            if(board[x--][y--]=='Q') return true;
        }

        ////forward diagonal check
        x = i-1;
        y=j+1;
        while(x>=0&&y<n){
            if(board[x--][y++]=='Q') return true;
        }
        return false;
    }

    public void helper(char board[][],int n,int x, List<List<String>> output){
        if(x==n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            output.add(temp);
            return;
        }

        for(int i=0;i<n;i++){
            if(!queenChecker(board,x,i)){
                board[x][i] = 'Q';
                helper(board,n,x+1,output);
                board[x][i] = '.';
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> output = new LinkedList<>();
        helper(board,n,0,output);
        return output;

    }
}