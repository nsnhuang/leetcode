package baidu1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[] a = new int[1001];
        int[] b = new int[1001];
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- != 0) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] == 0 && b[i] == 0) {
                    continue;
                }
                if (a[i] == 0) {
                    System.out.println("0/1");
                    break;
                }
                if (b[i] == 0) {
                    System.out.println("1/0");
                    break;
                }
                if (a[i] != 0 && b[i] != 0) {
                    System.out.println(a[i] + "/" + b[i]);
                }
            }
        }
    }
}