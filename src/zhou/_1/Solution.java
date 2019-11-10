package zhou._1;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }
        if ((coordinates[1][0] - coordinates[0][0]) == 0) {
            return processZreo(coordinates);
        }

        int stan = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        int remainder = (coordinates[1][1] - coordinates[0][1]) % (coordinates[1][0] - coordinates[0][0]);
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][0] - x) == 0) {
                return false;
            }
            int res = (coordinates[i][1] - y) / (coordinates[i][0] - x);
            int iRemainder = (coordinates[i][1] - y) % (coordinates[i][0] - x);
            if (res != stan || iRemainder != remainder) {
                return false;
            }
        }
        return true;
    }

    private boolean processZreo(int[][] coordinates) {
        int i = 2;
        while (i < coordinates.length && coordinates[i][0] - coordinates[i - 1][0] == 0) {
            i++;
        }
        return i == coordinates.length;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        boolean b = new Solution().checkStraightLine(nums);
    }
}