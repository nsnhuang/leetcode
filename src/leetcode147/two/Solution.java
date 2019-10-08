package leetcode147.two;

class Solution {
    public String alphabetBoardPath(String target) {
        char[] chars = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        int oldrow = 0;
        int oldcol = 0;
        for (char aChar : chars) {
            int location = aChar - 'a';
            int row = location / 5 - oldrow;
            int col = location % 5 - oldcol;
            if (row > 0) {
                for (int j = 0; j < row; j++) {
                    sb.append('D');
                }
            } else {
                for (int j = 0; j < -row; j++) {
                    sb.append('U');
                }
            }
            if (col > 0) {
                for (int j = 0; j < col; j++) {
                    sb.append('R');
                }
            } else {
                for (int j = 0; j < -col; j++) {
                    sb.append('L');
                }
            }
            sb.append('!');
            oldrow = location / 5;
            oldcol = location % 5;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String leet = solution.alphabetBoardPath("zdz");
        System.out.println(leet);
    }
}