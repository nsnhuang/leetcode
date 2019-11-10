package _922;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        while (i < A.length) {
            if ((A[i] & 1) == 1) {
                while ((A[j] & 1) == 1) {
                    j += 2;
                }

                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            i += 2;
        }
        return A;
    }
}