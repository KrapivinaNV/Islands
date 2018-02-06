package islands;

public class Coords {
    private int x;
    private int y;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "X = " + x +
                ", Y = " + y +
                '}';
    }
}