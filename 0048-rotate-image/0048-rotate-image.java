class Solution {
    public void rotate(int[][] matrix) {
        Queue<Integer> values = new LinkedList<>();
        int xlength = matrix.length;
        int yLength = matrix[0].length;
        for(int i=0;i<xlength;i++){
            for(int j=0;j<yLength;j++){
                values.add(matrix[i][j]);
            }
        }
        for(int j=yLength-1;j>=0;j--){
            for(int i=0;i<xlength;i++){
                matrix[i][j] = values.poll();
            }
        }
    }
}