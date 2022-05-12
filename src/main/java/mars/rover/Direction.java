package mars.rover;

public enum Direction {
    N(new Position(0, 1)) {
        @Override
        public Direction getNextLeftDirection() {
            return Direction.W;
        }

        @Override
        public Direction getNextRightDirection() {
            return Direction.E;
        }
    },
    W(new Position(-1, 0)) {
        @Override
        public Direction getNextLeftDirection() {
            return Direction.S;
        }

        @Override
        public Direction getNextRightDirection() {
            return Direction.N;
        }
    },
    S(new Position(0, -1)) {
        @Override
        public Direction getNextLeftDirection() {
            return Direction.E;
        }

        @Override
        public Direction getNextRightDirection() {
            return Direction.W;
        }
    },
    E(new Position(1, 0)) {
        @Override
        public Direction getNextLeftDirection() {
            return Direction.N;
        }

        @Override
        public Direction getNextRightDirection() {
            return Direction.S;
        }

    };

    private final Position position;

    Direction(Position nextPosition) {
        this.position = nextPosition;
    }

    public Position getBufferPosition() {
        return position;
    }

    public Direction getNextLeftDirection() {
        return this;
    }

    public Direction getNextRightDirection() {
        return this;
    }

}
