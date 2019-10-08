package leetcode120;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        List<Integer> down = triangle.get(size - 1);

        for (int i = size - 1 - 1; i >= 0; i--) {

            List<Integer> list = triangle.get(i);
            List<Integer> now = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                now.add(list.get(j) + Math.min(down.get(j),down.get(j + 1)));
            }
            down.clear();
            down.addAll(now);
            now.clear();
        }
        return down.get(0);
    }

    /**
     * ------------------------------------------------------------------------------------------
     */

    /**
     * 递归方法
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        dfs(triangle, 0, 0, 0);
        return minSum;
    }

    private int minSum = Integer.MAX_VALUE;

    private int dfs(List<List<Integer>> triangle, int i, int j, int sum) {
        // 出口
        if (i == triangle.size() - 1) {
            sum += triangle.get(i).get(j);
            if (sum < minSum) {
                minSum = sum;
            }
            return sum;
        }

        // 处理
        sum += triangle.get(i).get(j);

        // 递归
        dfs(triangle, i + 1, j, sum);
        dfs(triangle, i + 1, j + 1, sum);

        // 清理
        // 不需要清理
        return sum;
    }

    /**
     * -----------------------------------------------------------------------------------------
     */


    /**
     * 动态规划
     * @param triangle
     * @return
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                min += triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        triangle.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        triangle.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        triangle.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list4);

        Solution solution = new Solution();
        int i = solution.minimumTotal3(triangle);
        System.out.println(i);
    }
}