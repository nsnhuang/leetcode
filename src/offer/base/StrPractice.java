package offer.base;

import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 字符串练习题
 *
 * @author huang
 * @create 2019-09-12 9:20 AM
 */
public class StrPractice {
    /**
     * 讲字符串中的空格替换成%20
     * java方法
     */
    public void replaceBlank(String str) {
        if (str == null || str.length() == 0) {
            return ;
        }
        String[] sarray = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : sarray) {
            sb.append(s);
            sb.append("%20");
        }
        String s2 = sb.toString();
        System.out.println(s2);
    }

    /**
     * 讲字符串中的空格替换成%20
     * c语言方法（通用方法）
     */
    public void replaceBlank2(String str) {
        if (str == null || str.length() == 0) {
            return ;
        }
        int length = str.length();
        char[] chars = str.toCharArray();
        int count = 0;
        // 计算字符串中有多少空格
        for (char s: chars) {
            if (s == ' ') {
                count ++;
            }
        }

        int newLength = length + count * 2;
        char[] aim = new char[newLength];
        int j = newLength - 1;
        int i = length - 1;
        while (i >= 0) {
            if (chars[i] == ' ') {
                aim[j--] = '0';
                aim[j--] = '2';
                aim[j--] = '%';
                i --;
                continue;
            }
            aim[j] = chars[i];
            j--;
            i--;
        }

        System.out.println(aim);
    }

    /**
     * 合并两个排序数组，合并后依然有序
     */
    public void merge(int[] a1, int i, int[] a2) {
        if (a1 == null || a2 == null) {
            return ;
        }
        int length1 = a1.length;
        int length2 = a2.length;
        int p = length1 - 1;
        int j = length2 - 1;
        while (i >= 0 && j >= 0) {
            if (a1[i] > a2[j]) {
                a1[p] = a1[i];
                i --;
            } else {
                a1[p] = a2[j];
                j --;
            }
            p --;
        }
        if (j >= 0) {
            while (j >= 0) {
                a1[p] = a2[j];
                j --;
            }
        }
        for (int s: a1) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {
        StrPractice practice = new StrPractice();

//        practice.replaceBlank2(" we are  happy ");

        int[] a1 = new int[10];
        a1[0] = 1;
        a1[1] = 3;
        a1[2] = 5;
        a1[3] = 7;
        a1[4] = 9;
        practice.merge(a1, 4, new int[] {2,4,6,8,10});
    }

}