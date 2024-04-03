class Solution {

    public  static boolean validHelper(char[][]board,int startI,int startJ,int endI,int endJ){
        HashSet<Character> set = new HashSet<>();
        for(int i=startI;i<=endI;i++){
            for(int j=startJ;j<=endJ;j++){
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        ///sub boxes check
        for(int i=2,startI=0;i<board.length;i=i+3,startI=startI+3){
            for(int j=2,startJ=0;j<board[0].length;j=j+3,startJ=startJ+3){
                 if(!validHelper(board,startI,startJ,i,j)) return false;
            }
        }
        ///row check
        HashSet<Character>[] rowSet = new HashSet[9];
        for(int i=0;i<9;i++){
            rowSet[i] = new HashSet<>();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                if(!rowSet[i].contains(board[i][j])) rowSet[i].add(board[i][j]);
                else return false;
                
            }
        }
        
        //colSet
        HashSet<Character>[] colSet = new HashSet[9];
        for(int i=0;i<9;i++){
            colSet[i] = new HashSet<>();
        }
        for(int j=0;j<board[0].length;j++){
            for(int i=0;i<board.length;i++){
                if(board[i][j]=='.') continue;
                if(!colSet[j].contains(board[i][j]))  colSet[j].add(board[i][j]);
                else return false;
            }
        }
        return true;
    }
}