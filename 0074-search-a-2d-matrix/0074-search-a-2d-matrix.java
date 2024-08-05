class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0]>target || matrix[m-1][n-1]<target) return false;
        int rowToSearch = 0;
        for(int i=0;i<m;i++){
            int start = matrix[i][0];
            int end = matrix[i][n-1];
            if(target>=start&&target<=end){
                rowToSearch = i;
                break;
            }
        }
        System.out.println(rowToSearch);
        int arrToSearch[] = matrix[rowToSearch];
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arrToSearch[mid]==target||arrToSearch[start]==target||arrToSearch[end]==target) return true;
            else if(arrToSearch[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}