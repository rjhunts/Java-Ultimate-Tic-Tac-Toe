public class UltimateBoard extends Board {

    // Initialize board
    private Board[] ultBoard = new Board[9];
    
    // Board setup
    public UltimateBoard() {
        for (int i = 0; i < 9; i++) {
            Board board = new Board();
            this.ultBoard[i] = board;
        };
    };

    // Get block
    public Board getBlock(int block) {
        return this.ultBoard[block - 1];
    };

    // Validate if block is playable
    public boolean isValid(int block) {
        if (this.ultBoard[block - 1].checkState() != GameState.NONE) {
            return false;
        };

        for (int i = 0; i < 9; i++) {
            if (this.ultBoard[block - 1].getCell(i) == ' ') {
                return true;
            };
        };
        return false;
    };

    // Print board
    public void printBoard() {
        System.out.println("\nGame Board");
        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.println("+---+---+---+    +---+---+---+    +---+---+---+");
            System.out.println(this.ultBoard[i * 3].toString(0) + "    " + this.ultBoard[i * 3 + 1].toString(0) + "    " + this.ultBoard[i * 3 + 2].toString(0));
            System.out.println("+---+---+---+    +---+---+---+    +---+---+---+");
            System.out.println(this.ultBoard[i * 3].toString(3) + "    " + this.ultBoard[i * 3 + 1].toString(3) + "    " + this.ultBoard[i * 3 + 2].toString(3));
            System.out.println("+---+---+---+    +---+---+---+    +---+---+---+");
            System.out.println(this.ultBoard[i * 3].toString(6) + "    " + this.ultBoard[i * 3 + 1].toString(6) + "    " + this.ultBoard[i * 3 + 2].toString(6));
            System.out.println("+---+---+---+    +---+---+---+    +---+---+---+");
        };
        System.out.println();
    };
    
    private GameState state = GameState.NONE;
    private Players winner;

    // Set game state
    private void setGame(GameState state) {
        switch (state) {
            case WINNER:
                this.state = GameState.WINNER;
                break;
            
            case TIE:
                this.state = GameState.TIE;
                break;

            default:
                this.winner = Players.NULL;
                break;
        };
    };

    // Set winner state
    private void setWinner(Players current) {
        switch (current) {
            case X:
                this.winner = Players.X;
                setGame(GameState.WINNER);
                break;
            
            case O:
                this.winner = Players.O;
                setGame(GameState.WINNER);
                break;
                
            default:
                this.winner = Players.NULL;
                setGame(GameState.NONE);
                break;
        };
    };

    // Get winner
    public Players getWinner() {
        return this.winner;
    };

    // Get game state
    public GameState getState() {
        return this.state;
    };

    // Checks games current state
    public GameState checkState() {

        // Check Horizontal
        if (this.ultBoard[0].checkState() == GameState.WINNER && 
        this.ultBoard[3].checkState() == GameState.WINNER && 
        this.ultBoard[6].checkState() == GameState.WINNER 
        && 
        this.ultBoard[0].getWinner() == this.ultBoard[3].getWinner() &&
        this.ultBoard[0].getWinner() == this.ultBoard[6].getWinner()){
            setWinner(this.ultBoard[0].getWinner());
        }

        else if (this.ultBoard[1].checkState() == GameState.WINNER && 
        this.ultBoard[4].checkState() == GameState.WINNER && 
        this.ultBoard[7].checkState() == GameState.WINNER 
        && 
        this.ultBoard[1].getWinner() == this.ultBoard[4].getWinner() &&
        this.ultBoard[1].getWinner() == this.ultBoard[7].getWinner()){
            setWinner(this.ultBoard[1].getWinner());
        }

        else if (this.ultBoard[2].checkState() == GameState.WINNER && 
        this.ultBoard[5].checkState() == GameState.WINNER && 
        this.ultBoard[8].checkState() == GameState.WINNER
        && 
        this.ultBoard[2].getWinner() == this.ultBoard[5].getWinner() &&
        this.ultBoard[2].getWinner() == this.ultBoard[8].getWinner()) {
            setWinner(this.ultBoard[2].getWinner());
        }

        // Check Verical
        else if (this.ultBoard[0].checkState() == GameState.WINNER && 
        this.ultBoard[1].checkState() == GameState.WINNER && 
        this.ultBoard[2].checkState() == GameState.WINNER
        && 
        this.ultBoard[0].getWinner() == this.ultBoard[1].getWinner() &&
        this.ultBoard[0].getWinner() == this.ultBoard[2].getWinner()) {
            setWinner(this.ultBoard[0].getWinner());
        }

        else if (this.ultBoard[3].checkState() == GameState.WINNER && 
        this.ultBoard[4].checkState() == GameState.WINNER && 
        this.ultBoard[5].checkState() == GameState.WINNER
        && 
        this.ultBoard[3].getWinner() == this.ultBoard[4].getWinner() &&
        this.ultBoard[3].getWinner() == this.ultBoard[5].getWinner()) {
            setWinner(this.ultBoard[3].getWinner());
        }

        else if (this.ultBoard[6].checkState() == GameState.WINNER && 
        this.ultBoard[7].checkState() == GameState.WINNER && 
        this.ultBoard[8].checkState() == GameState.WINNER
        && 
        this.ultBoard[6].getWinner() == this.ultBoard[7].getWinner() &&
        this.ultBoard[6].getWinner() == this.ultBoard[8].getWinner()) {
            setWinner(this.ultBoard[6].getWinner());
        }
        
        // Check Diagonal
        else if (this.ultBoard[0].checkState() == GameState.WINNER && 
        this.ultBoard[4].checkState() == GameState.WINNER && 
        this.ultBoard[8].checkState() == GameState.WINNER
        && 
        this.ultBoard[0].getWinner() == this.ultBoard[4].getWinner() &&
        this.ultBoard[0].getWinner() == this.ultBoard[8].getWinner()) {
            setWinner(this.ultBoard[0].getWinner());
        }

        else if (this.ultBoard[2].checkState() == GameState.WINNER && 
        this.ultBoard[4].checkState() == GameState.WINNER && 
        this.ultBoard[6].checkState() == GameState.WINNER
        && 
        this.ultBoard[2].getWinner() == this.ultBoard[4].getWinner() &&
        this.ultBoard[2].getWinner() == this.ultBoard[6].getWinner()) {
            setWinner(this.ultBoard[2].getWinner());
        }

        // Check Tie
        else {
            boolean isTie = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (isValid(j + 1)) {
                        isTie = false;
                    };
                };
            };

            if (isTie) {
                setGame(GameState.TIE);
            };
        };
        
        return getState();
    };
};
