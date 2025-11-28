public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Ultimate Tic Tac Toe!");
        UltimateBoard ultimateBoard = new UltimateBoard();
        char[][] ult = ultimateBoard.board;
        ultimateBoard.printBoard();

        Actor player1 = new Actor('X');
        Actor player2 = new Actor('O');

        boolean winner = false;
        char[] boardWinners = new char[9];
        for (int i = 0; i < boardWinners.length; i++) {
            boardWinners[i] = 'N';
        };

        while (!winner) {
            int cell;
            Board board;
            while (true) {
                System.out.println(player1.getPlayer() + "'s Turn");
                cell = player1.getAction();
                board = new Board();
                board.setBoard(ult[cell]);
                ultimateBoard.setBoard(cell, board.getBoard());
                if (boardWinners[cell] == 'N') {
                    break;
                } else {
                    System.out.println("Invalid Board #\n");
                }
                System.out.println(boardWinners);
            };

            // Check winner
            
            boolean boardWinner = takeTurn(player1, board);
            if (boardWinner) {
                boardWinners[cell] = board.getBoard()[cell];
                cell += 1;
                System.out.println(player1.getPlayer() + " Wins Board #" + cell);
            }

            // Check tie
            if (board.checkTie()) {
                boardWinners[cell] = 'T';
                System.out.println("Tie!");
            };

            char gameWinner = ultimateBoard.checkWin(boardWinners);
            if (gameWinner != 'N') {
                winner = true;
                System.out.println(gameWinner + " Wins!");
            };

            ultimateBoard.printBoard();

            board = null;
            while (true) {
                System.out.println(player2.getPlayer() + "'s Turn");
                cell = player2.getAction();
                board = new Board();
                board.setBoard(ult[cell]);
                ultimateBoard.setBoard(cell, board.getBoard());
                if (boardWinners[cell] == 'N') {
                    break;
                } else {
                    System.out.println("Invalid Board #\n");
                }
            };

            boardWinner = takeTurn(player2, board);
            if (boardWinner) {
                boardWinners[cell] = board.getBoard()[cell];
                cell += 1;
                System.out.println(player2.getPlayer() + " Wins Board #" + cell);
                System.out.println(boardWinners);
                if (ultimateBoard.checkWin(boardWinners) != 'N') {
                    break;
                };
            };

            if (board.checkTie()) {
                System.out.println("Tie!");
            };

            gameWinner = ultimateBoard.checkWin(boardWinners);
            if (gameWinner != 'N') {
                winner = true;
                System.out.println(gameWinner + " Wins!");
            };

            ultimateBoard.printBoard();
        };
    };

    public static boolean takeTurn(Actor player, Board board) {
        board.printBoard();

        while (true) {
            try {
                int cell = player.getAction();
                if (board.isValid(cell)) {
                    board.setCell(cell, player.getPlayer());
                    board.printBoard();
                    break;
                } else {
                    System.out.println("Invalid cell option");
                    board.printBoard();
                }
            }
            catch (Exception e) {
                System.out.println("Invalid cell option");
                board.printBoard();
            };
        };
        if (board.checkWin()) {
            return true;
        };
        return false;
    };
};
