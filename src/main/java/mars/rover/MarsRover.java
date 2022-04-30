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

        if (roverInsideBoundary(currentPosition, newPosition, boundary)) {
            return new MarsRover(newXPosition, newYPosition, currentPosition.direction);
        }
        return currentPosition;
    }

    private boolean roverInsideBoundary(MarsRover currentPosition, Position nextPosition, Position boundary) {
        int newXPosition = currentPosition.x + nextPosition.getX();
        int newYPosition = currentPosition.y + nextPosition.getY();
        return boundary.checkIfRoverInsideBoundary(newXPosition, newYPosition);
    }

    private MarsRover findNewDirection(char instruction, MarsRover currentPosition) {
        Direction newDirection = null;
        Direction[] values = Direction.values();

        if (instruction == 'L') {
            for (int index = 0; index < values.length; index++) {
                if (values[index] == currentPosition.direction) {
                    newDirection = values[this.findNextDirection(values.length, index)];
                    break;
                }
            }
        } else {
            for (int index = 0; index < values.length; index++) {
                if (values[index] == currentPosition.direction) {
                    newDirection = findPreviousDirection(values, index);
                    break;
                }
            }
        }
        return new MarsRover(currentPosition.x, currentPosition.y, newDirection);

    }

    private int findNextDirection(int totalLength, int currentIndex) {
        return currentIndex + 1 >= totalLength ? 0 : currentIndex + 1;
    }

    private Direction findPreviousDirection(Direction[] values, int index) {
        return index - 1 < 0 ? values[values.length - 1] : values[index - 1];
    }

    public String getPositionDetails() {
        return this.x + " " + this.y + " " + this.direction;
    }
}
