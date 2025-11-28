public class Board {

    private static char winner = 'N';

    private char[] board = {' ', ' ', ' ',
                            ' ', ' ', ' ',
                            ' ', ' ', ' '};

    public void setBoard(char[] board) {
        this.board = board;
    };

    public char[] getBoard() {
        return this.board;
    };
    
    public void printBoard() {
        System.out.println();
        System.out.println("+---+---+---+");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("+---+---+---+");
        System.out.println();
    }

    public boolean checkWin() {

        // Check for horizontal win
        if (board[0] == board[1] && board[0] == board[2] && board[0] != ' ') {
            winner = board[0];
            return true;
        } 
        
        else if (board[3] == board[4] && board[3] == board[5] && board[3] != ' ') {
            winner = board[3];
            return true;
        }

        else if (board[6] == board[7] && board[6] == board[8] && board[6] != ' ') {
            winner = board[6];
            return true;
        }


        // Check for vorizontal win
        if (board[0] == board[3] && board[0] == board[6] && board[0] != ' ') {
            winner = board[0];
            return true;
        } 
        
        else if (board[1] == board[4] && board[1] == board[7] && board[1] != ' ') {
            winner = board[1];
            return true;
        }

        else if (board[2] == board[5] && board[2] == board[8] && board[2] != ' ') {
            winner = board[2];
            return true;
        }

        // Check for diagonal win
        else if (board[0] == board[4] && board[0] == board[8] && board[0] != ' ') {
            winner = board[0];
            return true;
        }

        else if (board[2] == board[4] && board[2] == board[6] && board[2] != ' ') {
            winner = board[2];
            return true;
        };

        return false;
    };

    public boolean checkTie() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                return false;
            }
        };
        return true;
    };

    public boolean isValid(int cell) {
        if (board[cell] != 'X' && board[cell] != 'O') {
            return true;
        };

        return false;
    };

    public void setCell(int cell, char player) {
        board[cell] = player;
    }

    public char getWinner() {
        return winner;
    };
}
