package baidu2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Integer[] a = new Integer[1001];
        Integer[] b = new Integer[1001];
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            Integer min = Integer.MAX_VALUE;
            Integer max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                if (b[i] < min) {
                    min = b[i];
                }
                if (a[i] > max) {
                    max = a[i];
                }
            }
            int res = (max - min) / 2;
            if ((max - min) % 2 != 0) {
                res ++;
            }
            System.out.println(res);
        }
    }
}