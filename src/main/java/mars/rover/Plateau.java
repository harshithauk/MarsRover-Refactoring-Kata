package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;

public class Plateau {
    private final Position boundary;
    MarsRover marsRover;

    public Plateau(int x, int y, MarsRover marsRover) throws InvalidBoundariesException {
        if (x <= 0 || y <= 0) {
            throw new InvalidBoundariesException();
        }
        boundary = new Position(x, y);
        this.marsRover = marsRover;
    }

    public void landRover(int x, int y, Direction direction) {
        marsRover = new MarsRover(x, y, direction);
    }

    public String moveRover(String instructions) {
        marsRover = marsRover.move(instructions, boundary);
        return marsRover.getPositionDetails();
    }
}
