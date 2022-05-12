package mars.rover;

import mars.rover.exceptions.InvalidBoundariesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarsRoverTest {

    @Test
    void shouldCheckIfRoverTurnsToItsLeftOnGivingAnInstructionToTurnLeft() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        MarsRover marsRover = plateau.moveRover("L");
        assertEquals("1 2 W", marsRover.getPositionDetails());
    }

    @Test
    void shouldCheckIfRoverTurnsToItsRightOnGivingAnInstructionToTurnRight() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.S));
        MarsRover marsRover = plateau.moveRover("R");
        assertEquals("1 2 W", marsRover.getPositionDetails());

    }

    @Test
    void shouldCheckIfRoverMovesAStepForwardOnGivingAnInstructionAsMove() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        MarsRover marsRover = plateau.moveRover("M");
        assertEquals("1 3 N", marsRover.getPositionDetails());
    }

    @Test
    void shouldCheckIfRoverIsAtTheExpectedPositionAfterFollowingGivenInstructions() throws InvalidBoundariesException {
        Plateau plateau = new Plateau(5, 5, new MarsRover(1, 2, Direction.N));
        MarsRover marsRover = plateau.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", marsRover.getPositionDetails());
    }

    @Test
    void shouldNotMoveTheRoverIfBoundaryIsInvalid(){
        MarsRover marsRover = new MarsRover(1, 2, Direction.N);
        assertThrows(InvalidBoundariesException.class,()->marsRover.move("M",new Position(-1,2)));
    }
}