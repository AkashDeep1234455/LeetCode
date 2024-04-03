class Solution {
     public static boolean helper(char[][]board,String word,int visited[][],int i,int j,int index){
        if(index==word.length()) return true;
        
        if(i<0||j>=board[0].length||i>=board.length||j<0||visited[i][j]==1||board[i][j]!=word.charAt(index)){
            return false;
        }
        visited[i][j] = 1;
        boolean result = helper(board,word,visited,i+1,j,index+1)||helper(board,word,visited,i,j+1,index+1)||
                helper(board,word,visited,i-1,j,index+1)||helper(board,word,visited,i,j-1,index+1);
        visited[i][j] = 0;
        return result;
    }
    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int column=board[0].length;
        int visited[][]=new int[rows][column];
        boolean check=true;
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                if(helper(board,word,visited,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
}