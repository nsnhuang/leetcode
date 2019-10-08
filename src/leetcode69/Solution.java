package leetcode69;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mySqrt(8);
    }

    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}