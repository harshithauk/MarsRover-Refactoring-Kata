package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlateauTest {
    @Test
    void shouldNotCreatePlateauForInvalidBoundaries() {
        assertThrows(InvalidBoundariesException.class, () -> new Plateau(-1, 5, new MarsRover(1, 2, Direction.N)));
    }

    @Test
    void shouldCheckIfRoverLandedOnPlateauFollowsInstructions() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        MarsRover marsRover = plateau.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", marsRover.getPositionDetails());
    }

}
