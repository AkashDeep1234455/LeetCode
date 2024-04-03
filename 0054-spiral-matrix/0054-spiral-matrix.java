class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>list = new ArrayList<>();
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int totalElements = xLength*yLength;
        int xIndex = 0;
        int xIndexEnd = xLength-1;
        int yIndexEnd = yLength-1;
        int yIndexStart = 0;
        while (list.size()!=totalElements){
            for(int j=xIndex;j<=yIndexEnd;j++){
                if(list.size()==totalElements) break;
                list.add(matrix[xIndex][j]);
            }
            for(int i=xIndex+1;i<=xIndexEnd;i++){
                if(list.size()==totalElements) break;
                list.add(matrix[i][yIndexEnd]);
            }
            for(int i=yIndexEnd-1;i>=yIndexStart;i--){
                if(list.size()==totalElements) break;
                list.add(matrix[xIndexEnd][i]);
            }
            xIndex++;
            for(int i=xIndexEnd-1;i>=xIndex;i--){
                if(list.size()==totalElements) break;
                list.add(matrix[i][yIndexStart]);
            }
            yIndexEnd--;
            yIndexStart++;
            xIndexEnd--;
        }
        return list;
    }
}