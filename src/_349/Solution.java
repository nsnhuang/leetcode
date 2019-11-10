package _349;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int aNums1 : nums1) {
            set1.add(aNums1);
        }
        for (int aNums2: nums2) {
            set2.add(aNums2);
        }

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer s : set1) {
            res[i ++] = s;
        }

        return res;
    }

}