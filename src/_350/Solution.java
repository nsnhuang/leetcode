package _350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int aNums1 : nums1) {
            if (!map1.containsKey(aNums1)) {
                map1.put(aNums1, map1.get(aNums1) + 1);
            } else {
                map1.put(aNums1, 1);
            }
        }

        for (int aNums2 : nums2) {
            if (!map2.containsKey(aNums2)) {
                map2.put(aNums2, map2.get(aNums2) + 1);
            } else {
                map2.put(aNums2, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        Set<Integer> key1 = map1.keySet();
        for (Integer k1 : key1) {
            if (map2.containsKey(k1)) {
                for (int i = 0; i < Math.min(map2.get(k1), map1.get(k1)); i++) {
                    list.add(k1);
                }
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer l : list) {
            res[i ++] = l;
        }

        return res;
    }
}