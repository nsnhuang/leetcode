package zhou161._1;

class Solution {
    public int minimumSwap(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                count ++;
            }
        }

        return count / 2;
    }
}