package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {

    @Test
    void shouldCheckIfPositionInsideBoundary() {
        assertEquals(true, new Position(3, 3).checkIfPositionInsideBoundary(new Position(2, 1)));
    }
}
