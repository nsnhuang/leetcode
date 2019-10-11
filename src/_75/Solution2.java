package _75;


class Solution2 {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = l;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i ++ ,l ++);
            } else if (nums[i] == 1) {
                i ++;
            } else if (nums[i] == 2) {
                swap(nums, i, r --);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,1,2};
        new Solution2().sortColors(nums);
        System.out.println(nums);
    }
}