package _524;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String aim : d) {
            boolean isOk = (aim.length() > res.length() || (aim.length() == res.length() && aim.compareTo(res) < 0)) && isSub(s, aim);
            if (isOk) {
                res = aim;
            }

        }
        return res;
    }

    private boolean isSub(String s, String aim) {
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            j = s.indexOf(aim.charAt(i), j);
            if (j == -1) {
               return false;
            }
            i ++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        String wo = new Solution().findLongestWord(s, list);
        System.out.println(wo);
    }
}

