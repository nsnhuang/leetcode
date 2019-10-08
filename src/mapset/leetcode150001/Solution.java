package mapset.leetcode150001;

import java.util.*;

/**
 * 两层for循环 查找c
 * 性能有待优化
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length + 2);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int reverse = (nums[i] + nums[j]) * -1;
                if (hashMap.containsKey(reverse) && hashMap.get(reverse) != i && hashMap.get(reverse) != j) {
                    int[] resarr = new int[]{nums[i], nums[j], reverse};
                    Arrays.sort(resarr);
                    result.add(Arrays.asList(resarr[0],resarr[1],resarr[2]));
                }
            }
        }
        // 最后结果判重可以使用Set，最后转成List
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, 4});
        System.out.println(lists);
    }
}