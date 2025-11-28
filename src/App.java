public class App {

    // Instantiate Ultimate Board
    static UltimateBoard ultBoard = new UltimateBoard();

    public static PlayerType getType(String option) {
        if (option == "1") {
            return PlayerType.Player;
        };
        return PlayerType.AI;
    };

    public static void playerTurn(Actor player) {

        System.out.println("\n" + player.getPlayer() + "'s Turn\n");

        System.out.print("Enter a block number: ");
        int block = Input.scanner.nextInt();

        while (!ultBoard.isValid(block)) {
            System.out.println("\nInvalid block position, please try again!");
            System.out.print("Enter a block number: ");
            block = Input.scanner.nextInt();
        };
        Board currentBlock = ultBoard.getBlock(block);

        System.out.print("Enter a cell number: ");
        int cell = Input.scanner.nextInt();

 
        while (!currentBlock.isValid(cell)) {
            System.out.println("\nInvalid cell position, please try again!");
            System.out.print("Enter a cell number: ");
            cell = Input.scanner.nextInt();
        }
        currentBlock.setCell(cell, player.getPlayer());
        
        ultBoard.printBoard();
        ultBoard.checkState();

        for (int i = 0; i < 3; i++) {
            System.out.println("+---+---+---+");
            System.out.print("| " + ultBoard.getBlock(i * 3 + 1).getWinner() + 
            " | " + ultBoard.getBlock(i * 3 + 2).getWinner() + 
            " | " + ultBoard.getBlock(i * 3 + 3).getWinner() + 
            " |\n");
        };
        System.out.println("+---+---+---+");
    };

    public static void main(String[] args) throws Exception {
        System.out.println("\nWelcome to Ultimate Tic Tac Toe!");
        ultBoard.printBoard();

        System.out.print("Player or AI (1, 2): ");
        String option = Input.scanner.nextLine();
        Actor player1 = new Actor('X', getType(option));

        System.out.print("Player or AI (1, 2): ");
        option = Input.scanner.nextLine();
        Actor player2 = new Actor('O', getType(option));
        
        while (ultBoard.getState() == GameState.NONE) {
            playerTurn(player1);

            if (ultBoard.getState() != GameState.NONE) {
                break;
            };

            playerTurn(player2);
        };

        if (ultBoard.getState() == GameState.WINNER) {
                System.out.println(ultBoard.getWinner() + " has won!");
            } else {
                System.out.println("The game is tied!");
        };
        Input.scanner.close();
    };
};
