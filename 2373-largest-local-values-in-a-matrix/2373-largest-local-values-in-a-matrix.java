class Solution {
    public static int findMaxInMatrix(int [][] grid,int i,int j,int k){
        int max= Integer.MIN_VALUE;
        for(int row =i;row<i+3;row++){
            for(int column=j;column<j+3;column++){
                int curr = grid[row][column];
                if(curr>max) max = curr;
            }
        }
        return max;
    }
    public int[][] largestLocal(int[][] grid) {
         int n = grid.length;
        int size = n-2;
        int[][] maxLocal = new int[size][size];
        int start =0;
        int end = 0;
        while (start<size){
            while (end<size){
                maxLocal[start][end] =findMaxInMatrix(grid,start,end,size);
                end++;
            }
            end=0;
            start++;
        }
        return maxLocal;
    }
}