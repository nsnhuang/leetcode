package _779;

class Solution {

    public int find(int N, int K, int remainder) {
        if (N == 1) {
            if (remainder == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int me = find(N - 1, (K + 1) / 2, K % 2);
        if (me == 0) {
            if (remainder == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return remainder;

        }
    }

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        return find(N - 1, (K + 1) / 2, K % 2);
    }
}

class Solution2 {

    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        int father = kthGrammar(N - 1, (K + 1) / 2);
        int remainder = K % 2;
        if (father == 0) {
            if (remainder == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return remainder;
        }
    }

    public static void main(String[] args) {
        new Solution2().kthGrammar(2,1);
    }
}