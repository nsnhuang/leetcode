package _969;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new LinkedList<>();
        int len = A.length;
        while (len > 1) {
            int i = 1;
            while (i < len) {
                if (A[i] == len) {
                    f(A, i + 1);
                    list.add(i + 1);
                    break;
                }
                i ++;
            }
            f(A, len);
            list.add(len);
            len --;
        }
        return list;
    }

    private void f(int[] a, int len) {
        int end = len - 1;
        int start = 0;
        while (start < end) {

            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;

            start ++;
            end --;
        }
    }
}