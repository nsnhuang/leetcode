package offer.base;

/**
 * 描述:
 * 数组练习题
 * @author huang
 * @create 2019-09-12 7:53 AM
 */
public class ArrayPractice {
    /**
     * 查找数组中重复的数字
     */
    public int duplicate(int[] numbers) {
        // 安全性检查
        int size = numbers.length;
        if (numbers == null || size == 0) {
            return -1;
        }
        for (int number : numbers) {
            if (number < 0 || number > size - 1) {
                return -1;
            }
        }

        // 遍历每一个数字
        for (int i = 0; i < size; i++) {
            while(numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }

                // 交换
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return -1;
    }

    /**
     * 不修改数组，查找数组中任意一个重复的数字
     */
    public int getDuplication(int[] numbers) {
        // 安全性检查
        int size = numbers.length;
        if (numbers == null || size == 0) {
            return -1;
        }
        for (int number : numbers) {
            if (number < 0 || number > size - 1) {
                return -1;
            }
        }

        // 二分判断
        int start = 0;
        int end = size - 1;
        while (start <= end) {
            // 使用位运算，提高效率
            int middle = (start + end) >> 1;
            int count = countRange(numbers, size, start, middle);

            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] numbers, int size, int start, int end) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i] <= end && numbers[i] >= start) {
                count ++;
            }
        }
        return count;
    }

    /**
     * 二维数组中的查找
     * 不能从左上角或者右下角开始找，因为不能缩小查找范围
     */
    boolean find(int[][] matrix, int number) {
        // 安全性检查
        if (matrix == null) {
            return false;
        }
        int rows = matrix.length;
        if (rows <= 0) {
            return false;
        }
        int columns = matrix[0].length;
        if (columns <= 0) {
            return false;
        }

        // 从右上角开始找，实现上要方便一些
        int row = 0;
        int column = columns - 1;
        while (row < rows && column < columns) {
            if (matrix[row][column] < number) {
                row ++;
            } else if (matrix[row][column] > number){
                column --;
            } else {
                return true;
            }
        }

        return false;
    }

}