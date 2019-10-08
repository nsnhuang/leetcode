package mapset.leetcode150002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 指针法
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // 排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (nums == null || n < 3) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            // 如果nums[i] > 0 那么后面全部 大于 0 退出
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int b = i + 1;
            int c = n - 1;
            while (b < c) {
                int sum = nums[i] + nums[b] + nums[c];
                if (sum > 0) {
                    c --;
                } else if (sum < 0) {
                    b ++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[b], nums[c]));
                    // 去重
                    while (b < c && nums[b] == nums[b + 1]) {
                        b ++;
                    }
                    while (b < c && nums[c] == nums[c - 1]) {
                        c --;
                    }
                    c --;
                    b ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}