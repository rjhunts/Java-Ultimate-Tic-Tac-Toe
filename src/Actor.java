public class Actor {
    private char player;
    private PlayerType playerType;

    public Actor(char player, PlayerType pType) {
        this.player = player;
        this.playerType = pType;
    };

    public char getPlayer() {
        return player;
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
