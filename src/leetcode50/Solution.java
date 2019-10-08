package leetcode50;

class Solution {
    /**
     * 二分法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // 这里注意int型从-2147483648 ～ 2147483647 所以直接取反会失败！！
        if (n < 0) {
            n = -1 * (n + 1);
            x = 1 / x;
            return x * myPow(x, n);
        }

        double pow = myPow(x, n / 2);

        return (n & 1) == 0 ? pow * pow : pow * pow * x;
    }

    /**
     * 位运算方法
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -1 * (n + 1);
            x = 1 / x;
            return x * myPow2(x, n);
        }
        double pow = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                pow *= x;
            }
            x *= x;
            n >>= 1;
        }
        return pow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double res = solution.myPow2(2.1, 3);
        System.out.println(res);
    }
}