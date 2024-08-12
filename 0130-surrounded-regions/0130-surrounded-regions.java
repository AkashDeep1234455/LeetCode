class Solution {
    static int[] xCoordinate = {0, 1, 0, -1};
    static int[] yCoordinate = {-1, 0, 1, 0};

    public static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'S'; // Mark as safe
        for (int i = 0; i < 4; i++) {
            dfs(board, x + xCoordinate[i], y + yCoordinate[i]);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        // Check the first and last rows
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i);
        }

        // Check the first and last columns
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }

        // Convert the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
