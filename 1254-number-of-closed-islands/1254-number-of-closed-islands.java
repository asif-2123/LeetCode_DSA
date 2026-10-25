class Solution {
    int m, n;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);
            if (grid[i][n - 1] == 0) dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) dfs(grid, 0, j);
            if (grid[m - 1][j] == 0) dfs(grid, m - 1, j);
        }
        int count = 0;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 1)    return;
        grid[r][c] = 1;
        for (int[] d : dirs) {
            dfs(grid, r + d[0], c + d[1]);
        }
    }
}