public class App {

    // Instantiate Ultimate Board
    static UltimateBoard ultBoard;
    
    public static Integer prevCell = null;

    public static PlayerType getType(String option) {
        if ("2".equals(option)) {
            return PlayerType.BOT;
        };
        return PlayerType.Player;
    };

    public static char formatPlayer(Board board) {
        if (board.getWinner() == Players.NULL && board.getState() == GameState.TIE) {
            return '/';
        };

        return board.getWinner().toString().charAt(0);
    };

    public static int setBlock(Integer block, Actor player) {
        while (!ultBoard.isValid(block)) {
            if (player.getPlayerType().equals(PlayerType.Player)) {
                if (block != prevCell) {
                    System.out.println("\nInvalid block position, please try again!");
                };
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("Enter a block number: ");
                    try {
                        block = Input.scanner.nextInt();
                        validInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid input, please enter a number!\n");
                        Input.scanner.nextLine();    
                    };
                };
            }
            
            else {
                block = BotHandler.getBlock(player, ultBoard);
            };
        };
        return block;
    };

    public static int setCell(Board currentBlock, int cell, Actor player) {
        while (!currentBlock.isValid(cell)) {
            if (currentBlock.getState() != GameState.NONE) {
                currentBlock = ultBoard.getBlock(BotHandler.getBlock(player, ultBoard));
            };

            if (player.getPlayerType().equals(PlayerType.Player)) {
                System.out.println("\nInvalid cell position, please try again!");
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("Enter a cell number: ");
                    try {
                        cell = Input.scanner.nextInt();
                        validInput = true;
                    } catch (Exception e) {
                        System.out.println("Invalid input, please enter a number!\n");
                        Input.scanner.nextLine();    
                    };
                };
            }

            else {
                cell = BotHandler.getCell(player, currentBlock);
            };
        };
        prevCell = cell;
        return cell;
    };

    public static void playerTurn(Actor player) {

        System.out.println("\n" + player.getPlayer() + "'s Turn\n");

        if (player.getPlayerType() == PlayerType.Player) {
            int block = setBlock(prevCell, player);
            Board currentBlock = ultBoard.getBlock(block);

            int cell = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter a cell number: ");
                try {
                    cell = Input.scanner.nextInt();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter a number!\n");
                    Input.scanner.nextLine();    
                };
            };

            int currentCell = setCell(currentBlock, cell, player);
            currentBlock.setCell(currentCell, player.getPlayer());
        }

        else {
            int block = setBlock(prevCell, player);
            Board currentBlock = ultBoard.getBlock(block);

            int cell = BotHandler.getCell(player, currentBlock);

            int currentCell = setCell(currentBlock, cell, player);
            currentBlock.setCell(currentCell, player.getPlayer());
        };
        
        ultBoard.printBoard();
        ultBoard.checkState();

        System.out.println("Game Tracker\n");
        for (int i = 0; i < 3; i++) {
            System.out.println("+---+---+---+");
            System.out.print(
             "| " + formatPlayer(ultBoard.getBlock(i * 3 + 1)) + 
            " | " + formatPlayer(ultBoard.getBlock(i * 3 + 2)) + 
            " | " + formatPlayer(ultBoard.getBlock(i * 3 + 3)) + 
            " |\n");
        };
        System.out.println("+---+---+---+");
    };

    public static void main(String[] args) throws Exception {
        prevCell = null;
        System.out.println("\nWelcome to Ultimate Tic Tac Toe!\n");
        ultBoard = new UltimateBoard();
        ultBoard.printBoard();

        System.out.print("Player 1: Human or Bot (1, 2): ");
        String option = Input.scanner.nextLine();
        Actor player1 = new Actor('X', getType(option));
        if (player1.getPlayerType() == PlayerType.BOT) {
            player1.initializeBot();
        };

        System.out.print("Player 2: Human or Bot (1, 2): ");
        option = Input.scanner.nextLine();
        Actor player2 = new Actor('O', getType(option));
        if (player2.getPlayerType() == PlayerType.BOT) {
            player2.initializeBot();
        };

        while (ultBoard.getState() == GameState.NONE) {
            playerTurn(player1);

            if (ultBoard.getState() != GameState.NONE) {
                break;
            };

            playerTurn(player2);
        };

        if (ultBoard.getState() == GameState.WINNER) {
            System.out.println("\n" + ultBoard.getWinner() + " has won!");
        } else {
            System.out.println("\nThe game is tied!");
        };

        System.out.print("\nPlay again? (y/n): ");
        option = Input.scanner.nextLine();
        if ("y".equals(option)) {
            main(args);
        };
        Input.scanner.close();
    };
};
