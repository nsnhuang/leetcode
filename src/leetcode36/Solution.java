package leetcode36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 可以再优化，性能低
 */
class Solution {

    private Set<Character> seti = new HashSet<>();
    private Set<Character> setj = new HashSet<>();
    private HashMap<Integer, Set<Character>> map = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (seti.contains(board[i][j])) {
                    return false;
                } else {
                    if (board[i][j] != '.') {
                        seti.add(board[i][j]);
                    }
                }
                if (setj.contains(board[j][i])) {
                    return false;
                } else {
                    if (board[j][i] != '.') {
                        setj.add(board[j][i]);
                    }
                }
                int block = (i / 3) * 3 + j / 3;
                if (map.containsKey(block)) {
                    Set<Character> characters = map.get(block);
                    if (characters.contains(board[i][j])) {
                        return false;
                    } else {
                        if (board[i][j] != '.') {
                            characters.add(board[i][j]);
                        }
                    }
                } else {
                    if (board[i][j] != '.') {
                        HashSet<Character> characters = new HashSet<>();
                        characters.add(board[i][j]);
                        map.put(block, characters);
                    }
                }
            }
            seti.clear();
            setj.clear();
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] array = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        Solution solution = new Solution();
        boolean validSudoku = solution.isValidSudoku(array);
        System.out.println(validSudoku);
    }
}