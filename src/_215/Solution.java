package _215;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while (start != end) {
            int i = partition(nums, start, end);
            if (i == k) {
                return nums[i];
            } else if (i < k) {
                start = i + 1;
            } else {
                end = i - 1;
            }
        }
        return nums[start];
    }

    public int partition(int[] A, int p, int r) {
        int pivot = A[r];
        int i = p;
        for (int j = p;j < r;j ++) {
            if (A[j] < pivot) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i = i+1;
            }
        }
        int tmp = A[i];
        A[i] = A[r];
        A[r] = tmp;

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int i = new Solution().findKthLargest(nums, 2);
        System.out.println(i);
    }
}