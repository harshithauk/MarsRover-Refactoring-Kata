package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Test
    void shouldCheckIfEastDirectionIsToTheRightOfNorthDirection() {
        assertEquals(Direction.E, Direction.N.getNextRightDirection());
    }

    @Test
    void shouldCheckIfWestDirectionIsToTheLeftOfNorthDirection() {
        assertEquals(Direction.W, Direction.N.getNextLeftDirection());
    }

    @Test
    void shouldCheckIfEastDirectionIsToTheLeftOfSouthDirection() {
        assertEquals(Direction.E, Direction.S.getNextLeftDirection());
    }

    @Test
    void shouldCheckIfWestDirectionIsToTheRighttOfSouthDirection() {
        assertEquals(Direction.W, Direction.S.getNextRightDirection());
    }

    @Test
    void shouldCheckIfNorthDirectionIsToTheLeftOfEastDirection() {
        assertEquals(Direction.N, Direction.E.getNextLeftDirection());
    }

    @Test
    void shouldCheckIfSouthDirectionIsToTheRightOfEastDirection() {
        assertEquals(Direction.S, Direction.E.getNextRightDirection());
    }

    @Test
    void shouldCheckIfNorthDirectionIsToTheRightOfWestDirection() {
        assertEquals(Direction.N, Direction.W.getNextRightDirection());
    }

    @Test
    void shouldCheckIfSouthDirectionIsToTheLeftOfWestDirection() {
        assertEquals(Direction.S, Direction.W.getNextLeftDirection());
    }
}
