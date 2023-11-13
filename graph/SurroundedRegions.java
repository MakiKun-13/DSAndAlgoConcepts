package graph;

public class SurroundedRegions {
    public static void main(String[] args) {
        solve(new char[][] {});
    }
    public static void solve(char[][] board) {
        for(int i=0; i<board.length; i++) {
            if(board[i][0]=='O') {
                dfs(board, i, 0);
            }
            if(board[i][board[0].length-1]=='O') {
                dfs(board, i, board[0].length-1);
            }
        }
        for(int j=0; j<board[0].length; j++) {
            if(board[0][j]=='O') {
                dfs(board, 0, j);
            }
            if(board[board.length-1][j]=='O') {
                dfs(board, board.length-1, j);
            }
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='*')
                    board[i][j]='O';
                else if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    public static void dfs(char[][] board, int i, int j) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) {
            return;
        }
        if(board[i][j]=='O')
            board[i][j] = '*';
        if(i>0 && board[i-1][j]=='O') {
            dfs(board, i-1, j);
        }
        if(i<board.length-1 && board[i+1][j]=='O') {
            dfs(board, i+1, j);
        }
        if(j>0 && board[i][j-1]=='O') {
            dfs(board, i, j-1);
        }
        if(j<board[0].length-1 && board[i][j+1]=='O') {
            dfs(board, i, j+1);
        }
    }
}
