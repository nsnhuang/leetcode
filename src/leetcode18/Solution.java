package leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (nums == null && n < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            // nums[i] > 0
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //int j = i + 1
            for (int j = i + 1; j < n; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        r --;
                    } else if(sum < target) {
                        l ++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[r] == nums[r - 1]) {
                            r --;
                        }
                        while (l < r && nums[l] == nums[l + 1]) {
                            l ++;
                        }
                        r --;
                        l ++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
        System.out.println(lists);
    }
}