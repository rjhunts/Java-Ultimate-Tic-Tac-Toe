public class Actor {
    private char player;
    private PlayerType playerType;
    private Difficulty difficulty;

    public Actor(char player, PlayerType pType) {
        this.player = player;
        this.playerType = pType;
    };

    public void initializeBot() {
        System.out.print("Enter bot difficulty, Easy or Normal (1, 2): ");
        String getDifficulty = Input.scanner.nextLine();
        switch (getDifficulty) {
            case "2":
                difficulty = Difficulty.NORMAL;
                break;

            default:
                difficulty = Difficulty.EASY;
                break;
        };
    };

    public Difficulty getDifficulty() {
        return difficulty;
    };
    
    public char getPlayer() {
        return player;
    };

    public Players getPlayerEnum() {
        if (getPlayer() == 'X') {
            return Players.X;
        }
        return Players.O;
    };

    public PlayerType getPlayerType() {
        return playerType;
    };

    public int getAction() {
        System.out.print("Enter number: ");
        int cell = Input.scanner.nextInt() - 1;
        return cell;
    };
};
