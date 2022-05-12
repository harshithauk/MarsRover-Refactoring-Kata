package mars.rover;

import java.util.Comparator;

public class Position implements Comparator {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkIfPositionInsideBoundary(Position newPosition) {
        Position origin = new Position(0, 0);
        Position maxPosition = this;

        return (compare(maxPosition, newPosition) == 1) && (newPosition.getX() >= origin.getX() && newPosition.getY() >= origin.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Position boundary = (Position) o1;
        Position newPosition = (Position) o2;

        if (boundary.getX() >= newPosition.getX() && boundary.getY() >= newPosition.getY()) {
            return 1;
        } else {
            return 0;
        }
    }
}
