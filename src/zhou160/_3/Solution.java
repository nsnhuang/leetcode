package zhou160._3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * no ac
 */
class Solution {
    Bom bom = new Bom();
    private List<String> res = new ArrayList<>();

    public int maxLength(List<String> arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.size() == 1) {
            return arr.get(0).length();
        }
        arr.sort(((o1, o2) -> o2.length() - o1.length()));

        for (String s1 : arr) {
            bom.match(s1);
        }
        return bom.count;
    }

    class Bom {
        HashSet<Character> set = new HashSet<>();
        Integer count = 0;
        String res;

        boolean match(String s) {
            char[] chars = s.toCharArray();
            Set<Character> self = new HashSet<>();
            for (char c1 : chars) {
                if (set.contains(c1)) {
                    return false;
                }
                if (self.contains(c1)) {
                    return false;
                }
                self.add(c1);
            }
            self.clear();
            for (char c : chars) {
                set.add(c);
                count ++;
            }
            res += s;
            return true;
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cha");
        list.add("r");
        list.add("act");
        list.add("ers");
        int i = new Solution().maxLength(list);
        System.out.println(i);
    }

}