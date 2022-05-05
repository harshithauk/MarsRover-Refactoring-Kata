package mars.rover;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkIfRoverInsideBoundary(int xPosition, int yPosition) {
        return (xPosition <= x && yPosition <= y && xPosition >= 0 && yPosition >= 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
