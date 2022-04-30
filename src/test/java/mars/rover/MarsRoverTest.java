package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    void shouldCheckIfRoverTurnsToItsLeftOnGivingAnInstructionToTurnLeft() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        String newPosition = plateau.moveRover("L");
        assertEquals("1 2 W", newPosition);
    }


    @Test
    void shouldCheckIfRoverTurnsToItsRightOnGivingAnInstructionToTurnRight() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        String newPosition = plateau.moveRover("R");
        assertEquals("1 2 E", newPosition);

    }

    @Test
    void shouldCheckIfRoverMovesAStepForwardOnGivingAnInstructionAsMove() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        String newPosition = plateau.moveRover("M");
        assertEquals("1 3 N", newPosition);
    }

    @Test
    void shouldCheckIfRoverIsAtTheExpectedPositionAfterFollowingGivenInstructions() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        String newPosition = plateau.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }

}