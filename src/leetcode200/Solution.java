package leetcode200;

class Solution {

    /**
     * 深度遍历 涂色
     */

    private int nr;
    private int nc;

    public void dfs(char[][] grid, int r, int c) {

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        nr = grid.length;
        nc = grid[0].length;

        int res = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * ---------------------------------------------------------------------------------
     */


    /**
     * 并查集
     */

}