package mars.rover;

public enum Direction {
    N(new Position(0, 1)),
    W(new Position(-1, 0)),
    S(new Position(0, -1)),
    E(new Position(1, 0));


    private final Position position;

    Direction(Position nextPosition) {
        this.position = nextPosition;
    }

    public Position getNextPosition() {
        return position;
    }

}
