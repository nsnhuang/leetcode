package baidu5;

import java.util.Scanner;

public class Main {
    private int m;
    private int[] res;
    {
        res = new int[1000000];
        res[1] = 1;
        m = 1;
    }
    public int ans(int n) {
        if (n > m) {
            for (int i = m + 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j < i; j++) {
                    sum += res[j] * (j);
                    while (sum >= i) {
                        sum -= i;
                    }
                }
                res[i] = sum;
            }
            m = n;
            return res[n];
        } else {
            return res[n];
        }
    }
    public static void main(String[] args){
        int[] a = new int[1001];
        int[] b = new int[1001];
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            Main mai = new Main();
            int ans = mai.ans(n);
            System.out.println(ans);
        }
    }
}