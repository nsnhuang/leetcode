package leetcode2420003;

import java.util.HashMap;

/**
 * s对数组对应位置+1，t对数组对应位置-1
 * 验证最后数组是否为全0
 */
class Solution {

    private HashMap<Character,Integer> hashMap = new HashMap<>();

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        for (char schar :
                s.toCharArray()) {
            if (hashMap.containsKey(schar)) {
                hashMap.put(schar, hashMap.get(schar) + 1);
            } else {
                hashMap.put(schar, 1);
            }
        }
        for (char tchar :
                t.toCharArray()) {
            if (hashMap.containsKey(tchar)) {
                hashMap.put(tchar, hashMap.get(tchar) - 1);
            } else {
                hashMap.put(tchar, -1);
            }
        }

        for (int count :
                hashMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}