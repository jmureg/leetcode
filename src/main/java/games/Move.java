package games;

public class Move {
    private int x;
    private int y;

    Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int xAsint() {
        return Integer.valueOf(this.x) - 1;
    }

    public int yAsint() {
        return Integer.valueOf(this.y) - 1;
    }
}
