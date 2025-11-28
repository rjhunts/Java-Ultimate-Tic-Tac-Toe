public class Board {

    // Instantiate board array
    private char[] board = {' ', ' ', ' ',
                            ' ', ' ', ' ',
                            ' ', ' ', ' '};
    
    // Validate if cell is playable
    public boolean isValid(int cell) {
        if (this.board[cell - 1] == ' ') {
            return true;
        };
        return false;
    };

    // Set cell
    public void setCell(int cell, char player) {
        this.board[cell - 1] = player;
    };

    // Get cell
    public char getCell(int i) {
        return this.board[i];
    };

    // String method to display Ultimate Board properly
    public String toString(int i) {
        return "| " + this.board[i] + " | " + this.board[i + 1] + " | " + this.board[i + 2] + " |";
    };

    // Print board method for single block
    public void printBoard() {
        System.out.println();
        System.out.println("+---+---+---+");
        System.out.println("| " + this.board[0] + " | " + this.board[1] + " | " + this.board[2] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + this.board[3] + " | " + this.board[4] + " | " + this.board[5] + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + this.board[6] + " | " + this.board[7] + " | " + this.board[8] + " |");
        System.out.println("+---+---+---+");
        System.out.println();
    };

    private GameState state = GameState.NONE;
    private Players winner = Players.NULL;

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
                this.state = GameState.NONE;
                break;
        };
    };

    // Set winner state
    private void setWinner(char current) {
        switch (current) {
            case 'X':
                this.winner = Players.X;
                setGame(GameState.WINNER);
                break;
            
            case 'O':
                this.winner = Players.O;
                setGame(GameState.WINNER);
                break;

            case 'T':
                this.winner = Players.NULL;
                setGame(GameState.TIE);
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
    private GameState getState() {
        return this.state;
    };

    // Checks games current state
    public GameState checkState() {

        // Check Horizontal
        if (this.board[0] == this.board[1] && this.board[0] == this.board[2] && this.board[0] != ' ') {
            setWinner(this.board[0]);
        } 
        
        else if (this.board[3] == this.board[4] && this.board[3] == this.board[5] && this.board[3] != ' ') {
            setWinner(this.board[3]);
        }

        else if (this.board[6] == this.board[7] && this.board[6] == this.board[8] && this.board[6] != ' ') {
            setWinner(this.board[6]);
        }

        // Check Vertical
        else if (this.board[0] == this.board[3] && this.board[0] == this.board[6] && this.board[0] != ' ') {
            setWinner(this.board[0]);
        } 
        
        else if (this.board[1] == this.board[4] && this.board[1] == this.board[7] && this.board[1] != ' ') {
            setWinner(this.board[1]);
        }

        else if (this.board[2] == this.board[5] && this.board[2] == this.board[8] && this.board[2] != ' ') {
            setWinner(this.board[2]);
        }

        // Check Diagonal
        else if (this.board[0] == this.board[4] && this.board[0] == this.board[8] && this.board[0] != ' ') {
            setWinner(this.board[0]);
        }

        else if (this.board[2] == this.board[4] && this.board[2] == this.board[6] && this.board[2] != ' ') {
            setWinner(this.board[2]);
        } 

        // Check Tie
        else {
            boolean isTie = true;
            for (int i = 0; i < 9; i++) {
                if (isValid(i + 1)) {
                    isTie = false;
                };
            };

            if (isTie) {
                setWinner('T');
            };
        };

        return getState();
    };
};