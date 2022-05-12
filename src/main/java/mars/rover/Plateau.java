package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;

public class Plateau {
    private final Position boundary;
    private MarsRover marsRover;

    public Plateau(int x, int y, MarsRover marsRover) throws InvalidBoundariesException {
        if (x <= 0 || y <= 0) {
            throw new InvalidBoundariesException();
        }
        boundary = new Position(x, y);
        this.marsRover = marsRover;
    }

    public MarsRover moveRover(String instructions) throws InvalidBoundariesException {
        marsRover = marsRover.move(instructions, boundary);
        return marsRover;
    }
}
