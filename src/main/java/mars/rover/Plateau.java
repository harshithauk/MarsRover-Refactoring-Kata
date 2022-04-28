package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;

public class Plateau {
    private final int[] boundary;
    MarsRover marsRover;

    public Plateau(int x, int y) throws InvalidBoundariesException {
        if (x <= 0 || y <=0 ){
            throw new InvalidBoundariesException();
        }
        boundary= new int[]{x, y};
    }

    public void landRover(int x, int y, char direction) {
        marsRover= new MarsRover(x,y,direction);
    }

    public String moveRover(String instructions) {
        return marsRover.move(instructions, boundary);
    }
}
