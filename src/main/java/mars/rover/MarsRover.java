package mars.rover;


public class MarsRover {

    private final int x;
    private final int y;
    private final Direction direction;


    public MarsRover(int x_coordinate, int y_coordinate, Direction direction) {
        this.x = x_coordinate;
        this.y = y_coordinate;
        this.direction = direction;
    }

    public MarsRover move(String instructions, Position boundary) {

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
        Position newPosition = currentPosition.direction.getNextPosition();
        int newXPosition = currentPosition.x + newPosition.getX();
        int newYPosition = currentPosition.y + newPosition.getY();

        if (boundary.checkIfRoverInsideBoundary(newXPosition, newYPosition)) {
            return new MarsRover(newXPosition, newYPosition, currentPosition.direction);
        }
        return currentPosition;
    }

    private MarsRover findNewDirection(char instruction, MarsRover currentPosition) {
        Direction newDirection;

        if (instruction == 'L') {
            newDirection = currentPosition.direction.getNextLeftDirection();
        } else {
            newDirection = currentPosition.direction.getNextRightDirection();
        }
        return new MarsRover(currentPosition.x, currentPosition.y, newDirection);
    }

    public String getPositionDetails() {
        return this.x + " " + this.y + " " + this.direction;
    }
}
