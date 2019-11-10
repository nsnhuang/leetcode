package zhou161._2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> key = new ArrayList<>();

        key.add(-1);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                key.add(i);
            }
        }
        key.add(nums.length);

        if (key.size() == 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < key.size() - k; i++) {
            int j = i + k - 1;

            int pre;
            int post;
            if (key.get(i) == 0) {
                pre = 1;
            } else {
                pre = key.get(i) - key.get(i - 1);
            }
            post = key.get(j + 1) - key.get(j);
            res += pre * post;
        }

        return res;
    }

    public static void main(String[] args) {
        int i = new Solution().numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2);
        System.out.println(i);
    }
}