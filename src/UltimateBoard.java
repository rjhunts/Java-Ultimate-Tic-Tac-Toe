public class UltimateBoard extends Board {
    
    char[][] board = new char[9][9];
    char winner;

    public UltimateBoard() {
        for (int i = 0; i < 9; i++) {
            Board b = new Board();
            board[i] = b.getBoard();
        };
    };

    public void setBoard(int n, char[] b) {
        board[n] = b;
    };

    @Override
    public void printBoard() {
        for (int i = 0; i < 3; i++) {   
            System.out.println("+---+---+---+" + "    " + "+---+---+---+" + "    " + "+---+---+---+");
            System.out.println("| " + board[0+3*i][0] + " | " + board[0+3*i][1] + " | " + board[0+3*i][2] + " |" + "    " + "| " + board[1+3*i][0] + " | " + board[1+3*i][1] + " | " + board[1+3*i][2] + " |" + "    " + "| " + board[2+3*i][0] + " | " + board[2+3*i][1] + " | " + board[2+3*i][2] + " |");
            System.out.println("+---+---+---+" + "    " + "+---+---+---+" + "    " + "+---+---+---+");
            System.out.println("| " + board[0+3*i][3] + " | " + board[0+3*i][4] + " | " + board[0+3*i][5] + " |" + "    " + "| " + board[1+3*i][3] + " | " + board[1+3*i][4] + " | " + board[1+3*i][5] + " |" + "    " + "| " + board[2+3*i][3] + " | " + board[2+3*i][4] + " | " + board[2+3*i][5] + " |");
            System.out.println("+---+---+---+" + "    " + "+---+---+---+" + "    " + "+---+---+---+");
            System.out.println("| " + board[0+3*i][6] + " | " + board[0+3*i][7] + " | " + board[0+3*i][8] + " |" + "    " + "| " + board[1+3*i][6] + " | " + board[1+3*i][7] + " | " + board[1+3*i][8] + " |" + "    " + "| " + board[2+3*i][6] + " | " + board[2+3*i][7] + " | " + board[2+3*i][8] + " |");
            System.out.println("+---+---+---+" + "    " + "+---+---+---+" + "    " + "+---+---+---+");
            System.out.println();
        };
    };
    
    public char checkWin(char[] boardWinners) {

        // Check Verical
        if (boardWinners[0] == boardWinners[1] && boardWinners[0] == boardWinners[2]) {
            return boardWinners[0];
        } 
        
        else if (boardWinners[3] == boardWinners[4] && boardWinners[3] == boardWinners[5]) {
            return boardWinners[3];
        } 
        
        else if (boardWinners[6] == boardWinners[7] && boardWinners[6] == boardWinners[8]) {
            return boardWinners[6];
        }

        // Check Horizontal
        else if (boardWinners[0] == boardWinners[3] && boardWinners[0] == boardWinners[6]) {
            return boardWinners[0];
        }        

        else if (boardWinners[1] == boardWinners[4] && boardWinners[1] == boardWinners[7]) {
            return boardWinners[1];
        }

        else if (boardWinners[2] == boardWinners[5] && boardWinners[2] == boardWinners[8]) {
            return boardWinners[2];
        }

        // Check Diagonal
        else if (boardWinners[0] == boardWinners[4] && boardWinners[0] == boardWinners[8]) {
            return boardWinners[0];
        }
        
        else if (boardWinners[2] == boardWinners[4] && boardWinners[2] == boardWinners[6]) {
            return boardWinners[2];
        };
        
        return 'N';
    };
};
