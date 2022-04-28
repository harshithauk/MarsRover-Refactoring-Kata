package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlateauTest {
    @Test
    void shouldNotCreateAPlateauForInvalidBoundaries() throws InvalidBoundariesException {
        assertThrows(InvalidBoundariesException.class, ()->new Plateau(-1, 5));
    }

    @Test
    void shouldCheckIfRoverLandedOnPlateauCanFollowInstructions() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5);
        plateau.landRover(1,2,'N');
        String newPosition = plateau.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }
}
