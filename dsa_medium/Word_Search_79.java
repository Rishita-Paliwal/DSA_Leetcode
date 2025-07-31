class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col) {
        // Base case: word is completely found
        if (index == word.length()) return true;

        // Boundary conditions and pruning
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length 
            || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#'; // any non-alphabetic marker

        // Explore in all 4 directions
        boolean found = dfs(board, word, index + 1, row - 1, col) || // up
                        dfs(board, word, index + 1, row + 1, col) || // down
                        dfs(board, word, index + 1, row, col - 1) || // left
                        dfs(board, word, index + 1, row, col + 1);   // right

        // Backtrack and unmark the cell
        board[row][col] = temp;

        return found;
    }
}
