class Solution {
    public boolean check(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        int val = grid[rowStart][colStart];  
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;  
    }

    public Node helper(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (check(grid, rowStart, rowEnd, colStart, colEnd)) {
       
            return new Node(grid[rowStart][colStart] == 1, true);
        }

      
        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (colStart + colEnd) / 2;

        Node topLeft = helper(grid, rowStart, rowMid, colStart, colMid);
        Node topRight = helper(grid, rowStart, rowMid, colMid + 1, colEnd);
        Node bottomLeft = helper(grid, rowMid + 1, rowEnd, colStart, colMid);
        Node bottomRight = helper(grid, rowMid + 1, rowEnd, colMid + 1, colEnd);

      
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public Node construct(int[][] grid) {
        return helper(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }
}
