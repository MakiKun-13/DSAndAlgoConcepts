package recursion;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(sudokuSolve(new char[][]{{'.','8','9','.','4','.','6','.','5'},
                {'.','7','.','.','.','8','.','4','1'},
        {'5','6','.','9','.','.','.','.','8'},
        {'.','.','.','7','.','5','.','9','.'},
        {'.','9','.','4','.','1','.','5','.'},
        {'.','3','.','9','.','6','.','1','.'},
        {'8','.','.','.','.','.','.','.','7'},
        {'.','2','.','8','.','.','.','6','.'},
        {'.','.','6','.','7','.','.','8','.'}}));
    }
    static boolean sudokuSolve(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='.') {
                    for(char k='1'; k<='9'; k++) {
                        if(isValid(board, k, i, j)) {
                            board[i][j] = k;
                            if(sudokuSolve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, char num, int i, int j) {
        //For the row
        for(int col=0; col<board.length; col++) {
            if(board[i][col]==num) {
                return false;
            }
        }
        //For the column
        for(int row=0; row<board[0].length; row++) {
            if(board[row][j]==num) {
                return false;
            }
        }
        //For the 3*3 matrix
        int startRow = 3*(i/3);
        int startCol = 3*(j/3);
        for(int row=0; row<3; row++) {
            for(int col=0; col<3; col++) {
                if(board[startRow + row][startCol + col] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
/**
 * Solved with back tracking
 */
