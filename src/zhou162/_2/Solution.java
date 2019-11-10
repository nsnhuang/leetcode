package zhou162._2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        int size2 = 0;
        for (int col : colsum) {
            sum += col;
            if (col == 2) {
                size2 ++;
            }
        }
        if (sum != upper + lower) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        upper -= size2;
        for (int i = 0; i < colsum.length; i++) {

            int col = colsum[i];
            if (col == 2) {
                res.get(0).add(i, 1);
                res.get(1).add(i, 1);
            } else if (col == 1) {
                if (upper > 0) {
                    upper --;
                    res.get(0).add(i, 1);
                    res.get(1).add(i, 0);
                } else {
                    res.get(0).add(i, 0);
                    res.get(1).add(i, 1);
                }
            } else {
                res.get(0).add(i, 0);
                res.get(1).add(i, 0);
            }
        }
        if (upper > 0) {
            return new ArrayList<>();
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().reconstructMatrix(5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1});
    }
}