package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;

public class MarsRover {
    private final int x;
    private final int y;
    private final Direction direction;

    public MarsRover(int x_coordinate, int y_coordinate, Direction direction) {
        this.x = x_coordinate;
        this.y = y_coordinate;
        this.direction = direction;
    }

    public MarsRover move(String instructions, Position boundary) throws InvalidBoundariesException {
        if (boundary.getX() <= 0 || boundary.getY() <= 0) {
            throw new InvalidBoundariesException();
        }
        MarsRover newPosition = this;
        for (int j = 0; j < instructions.length(); j++) {
            char instruction = instructions.charAt(j);
            if (instruction == 'L' || instruction == 'R') {
                newPosition = findNewDirection(instruction, newPosition);
            } else if (instruction == 'M') {
                newPosition = findNextPosition(newPosition, boundary);
            }
        }
        return newPosition;
    }

    private MarsRover findNextPosition(MarsRover currentPosition, Position boundary) {
        Position bufferPosition = currentPosition.direction.getBufferPosition();
        Position newRoverPosition = new Position(currentPosition.x + bufferPosition.getX(),currentPosition.y + bufferPosition.getY());
        if (boundary.checkIfPositionInsideBoundary(newRoverPosition)) {
            return new MarsRover(newRoverPosition.getX(), newRoverPosition.getY(), currentPosition.direction);
        }
        return currentPosition;
    }

    private MarsRover findNewDirection(char instruction, MarsRover currentPosition) {
        Direction newDirection = (instruction == 'L') ? currentPosition.direction.getNextLeftDirection() : currentPosition.direction.getNextRightDirection();
        return new MarsRover(currentPosition.x, currentPosition.y, newDirection);
    }

    public String getPositionDetails() {
        return this.x + " " + this.y + " " + this.direction;
    }
}
