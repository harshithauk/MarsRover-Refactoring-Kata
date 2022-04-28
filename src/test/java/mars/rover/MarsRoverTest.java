package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    void checkIfRoverIsAtTheExpectedPositionAfterFollowingGivenInstructions() {
        MarsRover marsRover = new MarsRover(1,2, 'N');
        String newPosition = marsRover.move( "LMLMLMLMM");
        assertEquals("1 3 N", newPosition);
    }

    @Test
    public void
    acceptance_test_2() {
        MarsRover marsRover = new MarsRover(3, 3, 'E');
        String newPosition = marsRover.move( "MMRMMRMRRM");
        assertEquals("5 1 E", newPosition);
    }

}