import java.util.Random;

public class BotHandler {

    private static Random random = new Random();

    public static int getBlock(Actor player, UltimateBoard board) {
        return random.nextInt(1, 10);
    };

    public static int getCell(Actor player, Board currentBlock) {
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

                // Check if winning cell
                if (board.isValid(i)) {
                    board.setCell(i, player1);
                } else {
                    continue;
                };

                board.checkState();
                board.printBoard();
                if (player.getPlayerEnum() == board.getWinner()) {
                    //System.out.println("Placed a winning move");
                    return i;
                } else {
                    board.setCell(i, ' ');
                };

                // Prevent opponent from winning
                if (board.isValid(i)) {
                    board.setCell(i, player2);
                } else {
                    continue;
                };

                board.checkState();
                board.printBoard();
                if (player2Enum == board.getWinner()) {
                    //System.out.println("Blocked " + player2 + " from winning");
                    return i;
                } else {
                    board.setCell(i, ' ');
                };
            };
        };
        return random.nextInt(1, 10);
    };
};