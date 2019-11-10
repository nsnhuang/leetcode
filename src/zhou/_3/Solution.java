package zhou._3;

class Solution {
    public int balancedString(String s) {
        int Q = 0;
        int W = 0;
        int E = 0;
        int R = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'Q' : Q ++; break;
                case 'W' : W ++; break;
                case 'E' : E ++; break;
                case 'R' : R ++; break;
            }
        }
        int min = Math.min(Math.min(Math.min(Q, W), E), R);
        Q -= min;
        W -= min;
        E -= min;
        R -= min;
        int average = (Q + W + E + R) / 4;
        int res = 0;
        if (Q > average) {
            res += (Q - average);
        }
        if (W > average) {
            res += (W - average);
        }
        if (E > average) {
            res += (E - average);
        }
        if (R > average) {
            res += (R - average);
        }

        return res;
    }

    public static void main(String[] args ){
        int qqwe = new Solution().balancedString("WWEQERQWQWWRWWERQWEQ");
    }
}