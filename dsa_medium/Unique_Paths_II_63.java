class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start or end is an obstacle
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        Integer[][] dp = new Integer[m][n];
        return helper(obstacleGrid, 0, 0, m - 1, n - 1, dp);
    }

    public int helper(int[][] grid, int startingRow, int startingCol, int endRow, int endCol, Integer[][] dp) {
        // Out of bounds or obstacle
        if (startingRow > endRow || startingCol > endCol || grid[startingRow][startingCol] == 1) {
            return 0;
        }

        // Reached destination
        if (startingRow == endRow && startingCol == endCol) {
            return 1;
        }

        // Return cached result
        if (dp[startingRow][startingCol] != null) {
            return dp[startingRow][startingCol];
        }

        // Move down and right
        int down = helper(grid, startingRow + 1, startingCol, endRow, endCol, dp);
        int right = helper(grid, startingRow, startingCol + 1, endRow, endCol, dp);

        // Cache and return the result
        return dp[startingRow][startingCol] = down + right;
    }
}
