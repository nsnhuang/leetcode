package _1030;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j][0] = i;
                res[i * C + j][1] = j;
            }
        }
        Arrays.sort(res, (o1, o2) -> {
            int i1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int i2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return i1 - i2;
        });
        return res;
    }
}