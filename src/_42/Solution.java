package _42;

class Solution {
    public int trap(int[] height) {
        boolean over = false;
        int len = height.length;
        int count = 0;
        int level = 1;

        int max = 0;
        for (int aHeight : height) {
            if (aHeight > max) {
                max = aHeight;
            }
        }

        while (level <= max) {
            int i = 0;
            while (i < len) {
                int aCount = 0;
                if (height[i] >= level) {
                    while (i + 1 < len && height[i + 1] <= level - 1) {
                        i ++;
                        aCount ++;
                    }
                }
                if (i + 1 >= len) {
                    aCount = 0;
                }
                count += aCount;
                i ++;
            }

            level ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new Solution().trap(nums);
        System.out.println(trap);
    }
}

class Solution2 {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left ++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new Solution2().trap(nums);
        System.out.println(trap);
    }
}