package _5222;

class Solution {
    public int balancedStringSplit(String s) {

        char[] chars = s.toCharArray();
        int res = 0;
        int Rcount = 0;
        int Lcount = 0;
        for (int i = 0; i < chars.length;i ++) {
            if (chars[i] == 'R') {
                Rcount ++;
            }
            if (chars[i] == 'L') {
                Lcount ++;
            }
            if (Rcount == Lcount) {
                Rcount = 0;
                Lcount = 0;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int count = new Solution().balancedStringSplit("RLRLRRLRRLLLRRLL");
        System.out.println(count);
    }
}