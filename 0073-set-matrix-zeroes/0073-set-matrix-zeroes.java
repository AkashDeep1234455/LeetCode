class Solution {
    public void valueChanger(int [][] matrix,int x,int y){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<x;i++){
            matrix[i][y]=0;
        }
        for(int i=x+1;i<m;i++){
            matrix[i][y]=0;
        }
        for(int j=0;j<y;j++){
            matrix[x][j]=0;
        }
        for(int j=y+1;j<n;j++){
            matrix[x][j]=0;
        }
    }
    
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> zeroIndex = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    int[] entry = new int[]{i,j};
                    zeroIndex.add(entry);
                }
            }
        }
        for(int i=0;i<zeroIndex.size();i++){
            int[] curr = zeroIndex.get(i);
            valueChanger(matrix,curr[0],curr[1]);
        }
    }
}