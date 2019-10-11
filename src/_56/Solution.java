package _56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0 || intervals[0].length == 0) {
            return null;
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] now = intervals[i];
            int[] last = res.get(res.size() - 1);
            if (now[0] > last[1]) {
                res.add(now);
            } else {
                last[1] = Math.max(now[1], last[1]);
            }
        }
        int[][] ress = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ress[i] = res.get(i);
        }

        return ress;
    }
}