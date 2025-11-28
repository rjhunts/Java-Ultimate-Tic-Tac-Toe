public class Actor {
    private char player;

    public Actor(char player) {
        this.player = player;
    };

    public char getPlayer() {
        return player;
    };

    public int getAction() {
        System.out.print("Enter number: ");
        int cell = Input.scanner.nextInt() - 1;
        return cell;
    };
};
