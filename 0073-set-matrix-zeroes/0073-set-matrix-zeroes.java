class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer[],Boolean> index = new HashMap<>();
        int xlength = matrix.length;
        int yLength = matrix[0].length;
        for(int i=0;i<xlength;i++){
            for(int j=0;j<yLength;j++){
                if(matrix[i][j]==0) {
                    Integer entry[] = new Integer[2];
                    entry[0] = i;
                    entry[1] = j;
                    index.put(entry,true);
                }
            }
        }
        for(Integer[] key:index.keySet()){
            Integer [] arr = key;
            int xindex = arr[0];
            int yindex = arr[1];
            for(int i=xindex;i>=0;i--){
                matrix[i][yindex]=0;
            }
            for(int i=xindex;i<xlength;i++){
                matrix[i][yindex]=0;
            }
            for(int i=yindex;i>=0;i--){
                matrix[xindex][i]=0;
            }
            for(int i=yindex;i<yLength;i++){
                matrix[xindex][i]=0;
            }
        }
    }
}