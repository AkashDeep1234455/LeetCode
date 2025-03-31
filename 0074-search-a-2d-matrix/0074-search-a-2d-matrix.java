class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[i][n-1]==target) return true;
            else if(matrix[i][n-1]>target){
                row = i;
                break;
            }
        }
        int start = 0;
        int end = n-1;
        while(start<end){
            int mid = (start+end)/2;
            if(matrix[row][mid]==target||matrix[row][start]==target||matrix[row][end]==target) return true;
            else if(matrix[row][mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}