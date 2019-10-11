package _75;


class Solution {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int i = 0;
        int j = length - 1;
        int count = 0;
        while (i < j) {

            if (nums[i] == 2 || nums[j] == 0) {
                swap(nums, i, j);
            }

            while (nums[i] == 0 || nums[j] == 2) {
                if (nums[i] == 0 && i <= length - 1) {
                    i ++;
                }
                if (nums[j] == 2 && j > 0) {
                    j --;
                }
                if (i == j) {
                    break;
                }
            }

            if (nums[i] == 1 && nums[j] == 1 && i != j) {
                nums[i] = 0;
                nums[j] = 2;
                i ++;
                j --;
                count ++;
            }
        }

        if (i == j) {
            if (nums[i] == 0) {
                i ++;
            } else if (nums[i] == 2) {
                j --;
            } else {
                i ++;
                j --;
            }
        }
        for (int k = 0; k < count; k++) {
            nums[i ++] = 1;
            nums[j --] = 1;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        new Solution().sortColors(nums);
        System.out.println(nums);
    }
}