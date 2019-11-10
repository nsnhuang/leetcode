package zhou162._1;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[][] res = new boolean[n][m];
        for (int[] aInd : indices) {
            for (int i = 0; i < m; i++) {
                res[aInd[0]][i] = !res[aInd[0]][i];
            }
            for (int i = 0; i < n; i++) {
                res[i][aInd[1]] = !res[i][aInd[1]];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j]) {
                    count ++;
                }
            }
        }
        return count;
    }
}