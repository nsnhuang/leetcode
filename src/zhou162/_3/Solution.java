package zhou162._3;

class Solution {
    public int closedIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                set2(grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 0) {
                set2(grid, i, grid[0].length - 1);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 0) {
                set2(grid, 0, i);
            }
            if (grid[grid.length - 1][i] == 0) {
                set2(grid, grid.length - 1, i);
            }
        }

        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if(grid[i][j] == 0) {
                    count ++;
                    set2(grid, i ,j);
                }
            }
        }
        return count;
    }

    private void set2(int[][] grid, int row, int col) {
        int m=grid.length;
        int n=grid[0].length;
        if((row<0)||(row>=m)||(col<0)||(col>=n)||(grid[row][col]!=0)){
            return;
        }
        grid[row][col]=2;
        set2(grid,row+1,col);
        set2(grid,row-1,col);
        set2(grid,row,col+1);
        set2(grid,row,col-1);
    }
}