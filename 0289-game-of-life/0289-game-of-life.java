class Solution {
     public static int [] X= {0,0,1,1,1,-1,-1,-1};
    public static int [] Y= {-1,1,-1,1,0,-1,1,0};
    public static int noOfLiveNeighbour(int [][]board,int i,int j){
        int liveCount = 0;
        for(int index=0;index<X.length;index++){
            int XCoordinate = i+X[index];
            int YCoordinate = j+Y[index];
            if(XCoordinate>=0&&XCoordinate<board.length&&YCoordinate>=0&&YCoordinate<board[0].length){
                if(board[XCoordinate][YCoordinate]==1) liveCount++;
            }
        }
        return liveCount;
    }
    public void gameOfLife(int[][] board) {
        int xLength= board.length;
        int ylength = board[0].length;
        int copyBoard[][] = new int[xLength][ylength];
           for(int i=0;i<xLength;i++){
               for(int j=0;j<ylength;j++){
                   int liveCOunt = noOfLiveNeighbour(board,i,j);
                   if(board[i][j]==1&&liveCOunt<2){
                       copyBoard[i][j]=0;
                   }else if(board[i][j]==0&&liveCOunt==3){
                       copyBoard[i][j] =1;
                   }else if(board[i][j]==1&&liveCOunt==2||liveCOunt==3){
                       copyBoard[i][j]= 1;
                   }else if(board[i][j]==1&&liveCOunt>3){
                       copyBoard[i][j] = 0;
                   }else{
                       copyBoard[i][j] = 0;
                   }
               }
           }
           for(int i=0;i<xLength;i++){
               for(int j=0;j<ylength;j++){
                   board[i][j] = copyBoard[i][j];
               }
           }
    }
}