package _96;

class Solution {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        return nums(n);
    }

    private int nums(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = nums(i);
            int right = nums(n - 1 - i);
            sum += (left * right);
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums = new Solution().numTrees(3);
        System.out.println(nums);
    }
}

class Solution2 {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        return nums(n);
    }

    private int nums(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - 1 - j];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        int nums = new Solution().numTrees(3);
        System.out.println(nums);
    }
}