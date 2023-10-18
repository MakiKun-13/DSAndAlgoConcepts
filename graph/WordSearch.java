package graph;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},
                                              {'S','F','E','S'},
                                              {'A','D','E','E'}}, "ABCESEEEFS"));
    }
    public static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(findWord(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean findWord(int i, int j, char[][] board, String word, int index) {
        if(index==word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(index))
            return false;

        char temp = board[i][j];
        board[i][j] = '*';

        boolean down = findWord(i+1, j, board, word, index+1);

        boolean up = findWord(i-1, j, board, word, index+1);

        boolean right = findWord(i, j+1, board, word, index+1);

        boolean left = findWord(i, j-1, board, word, index+1);

        board[i][j] = temp;
        return (left || right || up || down);
    }
}
