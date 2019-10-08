package leetcode147.one;

class Solution {
    public int tribonacci(int n) {
        int result = -1;
        if (n == 0) {
            return 0;
        }else if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 1;
        } else {
            int t0 = 0;
            int t1 = 1;
            int t2 = 1;
            while (n >= 3) {
                result = t0 + t1 + t2;
                t0 = t1;
                t1 = t2;
                t2 = result;
                n --;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int tribonacci = solution.tribonacci(4);
        System.out.println(tribonacci);
    }
}