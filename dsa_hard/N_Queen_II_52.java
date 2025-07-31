class Solution { 
    // Chess board
    boolean[][] board;

    public int totalNQueens(int n) {
        board = new boolean[n][n];
        return helper(0, n);
    }

    boolean willIPlaceAQueen(int row, int col) {
        // Check above in same column
        for (int i = row; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }

    int helper(int row, int n) {
        // Base case: placed queens in all rows
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < n; col++) {
            if (willIPlaceAQueen(row, col)) {
                board[row][col] = true;
                count += helper(row + 1, n);
                board[row][col] = false; // backtrack
            }
        }

        return count; // return result to avoid "missing return statement" error
    }
}
