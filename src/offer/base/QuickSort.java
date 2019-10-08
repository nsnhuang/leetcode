package offer.base;

import java.util.Arrays;
import java.util.Random;

/**
 * 描述:
 * 快速排序
 *
 * @author huang
 * @create 2019-09-12 7:02 PM
 */
public class QuickSort {
    public int[] quickSort (int[] data, int start, int end) throws Exception {
        if (start == end) {
            return null;
        }
        // 二分，返回中间下标
        int index = partition(data, start, end);
        if (index > start) {
            // 递归前半段
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            // 递归后半段
            quickSort(data, index + 1, end);
        }
        return data;
    }

    private int partition(int[] data, int start, int end) throws Exception {
        // 安全检查
        if (data == null || data.length <= 0 || start < 0 || end >= data.length) {
            throw new Exception("非法");
        }
        // 选取随机数，移动到末尾
        int index = randomInRange(start, end);
        swap(data, index, end);

        //
        int small = start - 1;
        for (index = start; index < end; index ++) {
            if (data[index] < data[end]) {

                small ++;
                if (index != small) {
                    swap(data, index, small);
                }
            }
        }
        small ++;
        swap(data, small, end);
        return small;
    }

    private void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }


    private int randomInRange(int start, int end) {
        return start + new Random().nextInt(end);
    }

    public static void main(String[] args) throws Exception {
        QuickSort quickSort = new QuickSort();
        int[] data = quickSort.quickSort(new int[]{5, 7, 6, 4, 2, 8}, 0, 5);
        System.out.println(Arrays.toString(data));
    }

}