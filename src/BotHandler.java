import java.util.Random;

public class BotHandler {

    private static Random random = new Random();

    public static int getBlock(Difficulty difficulty) {
        return random.nextInt(1,10);
    };

    public static int getCell(Difficulty difficulty, Board currentBlock) {
        if (Difficulty.MEDIUM == difficulty) {

            // Create a new board instance and make it a copy of the current block
            Board block = new Board();
            for (int i = 0; i < 9; i++) {
                char cell = currentBlock.getCell(i);
                block.setCell(i, cell);
            };

            
        };
        return random.nextInt(1,10);
    };
};