package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {

    @Test
    void shouldCheckIfRoverIsAtTheExpectedPositionAfterFollowingGivenInstructions() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        plateau.moveRover("LMLMLMLMM");
        plateau.landRover(1, 1, Direction.E);
        String newPosition = plateau.moveRover("MMLMML");
        assertEquals("3 3 W", newPosition);
    }
}
