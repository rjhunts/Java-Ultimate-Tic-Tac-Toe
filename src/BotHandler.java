import java.util.Random;

public class BotHandler {

    private static Random random = new Random();

    public static int getBlock(Actor player, UltimateBoard board) {
        return random.nextInt(1, 10);
    };

    public static int getCell(Actor player, Board currentBlock) {

        /** Bots currently only have Easy and Normal difficulty
         *  Was gonna add Hard as well but requires me to implement
         *  Minimax algorithm, might add later
         */

        if (Difficulty.NORMAL == player.getDifficulty()) {

            Board board = new Board();
            for (int i = 1; i <= 9; i++) {
                board.setCell(i, currentBlock.getCell(i-1));
            };

            char player1 = player.getPlayer();
            char player2 = ' ';
            Players player2Enum = Players.NULL;
            if (player1 == 'X') {
                player2 = 'O';
                player2Enum = Players.O;
            } else {
                player2 = 'X';
                player2Enum = Players.X;
            };

            for (int i = 1; i <= 9; i++) {

                // Check for a winning cell
                if (board.isValid(i)) {
                    board.setCell(i, player1);
                } else {
                    continue;
                };

                board.checkState();
                //board.printBoard();
                if (player.getPlayerEnum() == board.getWinner()) {
                    //System.out.println("Placed a winning move");
                    return i;
                } else {
                    board.setCell(i, ' ');
                };
            };

            for (int i = 1; i <= 9; i++) {

                // Otherwise prevent opponent from possibly winning a cell
                if (board.isValid(i)) {
                    board.setCell(i, player2);
                } else {
                    continue;
                };

                board.checkState();
                //board.printBoard();
                if (player2Enum == board.getWinner()) {
                    //System.out.println("Blocked " + player2 + " from winning");
                    return i;
                } else {
                    board.setCell(i, ' ');
                };
            }
        };

        // Otherwise assumes difficulty is set to Easy
        return random.nextInt(1, 10);
    };
};