public class WinLogic {
    String[][] board;

    WinLogic(String[][] board) {
        this.board = board;
    }

    public boolean winner_player(String player) {
        if (checkRowandColumn(player)) return true;
        else if (checkDiagonal(player)) return true;
        else return false;
    }

    private boolean checkRowandColumn(String player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals(player)) && (board[i][1].equals(player)) && (board[i][2].equals(player))) {
                return true;
            } else if ((board[0][i].equals(player)) && (board[1][i].equals(player)) && (board[2][i].equals(player))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonal(String player) {
        if (((board[0][0].equals(player)) && (board[1][1].equals(player)) && (board[2][2].equals(player)))) {
            return true;
        } else return (board[0][2].equals(player)) && (board[1][1].equals(player)) && (board[2][0].equals(player));
    }

}
