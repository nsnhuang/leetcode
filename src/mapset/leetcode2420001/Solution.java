package mapset.leetcode2420001;

import java.util.Arrays;

/**
 * 排序
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar, tchar);
    }
}