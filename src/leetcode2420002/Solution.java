package leetcode2420002;

/**
 * s对数组对应位置+1，t对数组对应位置-1
 * 验证最后数组是否为全0
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count :
                counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}