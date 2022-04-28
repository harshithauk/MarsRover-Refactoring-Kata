package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    void shouldCheckIfRoverTurnsToItsLeftOnGivingAnInstructionToTurnLeft() {
        MarsRover marsRover = new MarsRover(1, 2, 'N');
        String newPosition = marsRover.move("L", new int[]{5, 5});
        assertEquals("1 2 W", newPosition);
    }

    @Test
    void shouldCheckIfRoverTurnsToItsRIghtOnGivingAnInstructionToTurnRight() {
        MarsRover marsRover = new MarsRover(1, 2, 'N');
        String newPosition = marsRover.move("R", new int[]{5, 5});
        assertEquals("1 2 E", newPosition);
    }

    @Test
    void shouldCheckIfRoverMovesAStepForwardOnGivingAnInstructionAsMove() {
        MarsRover marsRover = new MarsRover(1, 2, 'N');
        String newPosition = marsRover.move("M", new int[]{5, 5});
        assertEquals("1 3 N", newPosition);
    }

    @Test
    void shouldCheckIfRoverIsAtTheExpectedPositionAfterFollowingGivenInstructions() {
        MarsRover marsRover = new MarsRover(1, 2, 'N');
        String newPosition = marsRover.move("LMLMLMLMM", new int[]{5, 5});
        assertEquals("1 3 N", newPosition);
    }

//    @Test
//    public void
//    acceptance_test_2() {
//        MarsRover marsRover = new MarsRover(3, 3, 'E');
//        String newPosition = marsRover.move( "MMRMMRMRRM");
//        assertEquals("5 1 E", newPosition);
//    }


}