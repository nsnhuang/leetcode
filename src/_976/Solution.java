package _976;

import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int i = A.length - 3;
        while (i > 0) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
            i --;
        }
        return 0;
    }
}

class Solution2 {
    public int largestPerimeter(int[] A) {
        int maxA = max(A);
        int maxB = max(A);
        int maxC = max(A);
        while (maxC != 0) {
            if (maxA + maxB > maxC) {
                return maxA + maxB + maxC;
            }
            maxA = maxB;
            maxB = maxC;
            maxC = max(A);
        }
        return 0;
    }

    private int max(int[] a) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        if (maxIndex != -1) {
            a[maxIndex] = -1;
        }
        return max;
    }
}