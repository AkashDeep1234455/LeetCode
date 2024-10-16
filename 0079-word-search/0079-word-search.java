class Solution {
    private static int x[] = {1,-1,0,0};
    private static int y[] = {0,0,1,-1};

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean visited[][] = new boolean[row][col];
                    boolean ans = helper(board,word,visited,i,j);
                    if(ans) return true;
                }
            }
        }
        return false;

    }
    private boolean helper(char[][]board, String word,boolean[][]visited,int oldX,int oldY){
        if(word.length()==0){
            return true;
        }
        if(oldX<0||oldY<0||oldX>=board.length||oldY>=board[0].length||visited[oldX][oldY]) return false;
        if(board[oldX][oldY]!=word.charAt(0)) return false;
        visited[oldX][oldY] = true;
        boolean result = helper(board,word.substring(1),visited,oldX+1,oldY)||helper(board,word.substring(1),visited,oldX-1,oldY)||helper(board,word.substring(1),visited,oldX,oldY+1)||helper(board,word.substring(1),visited,oldX,oldY-1);
        visited[oldX][oldY] = false;
        return result;
    }
}