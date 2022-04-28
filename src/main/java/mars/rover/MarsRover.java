package mars.rover;


public class MarsRover {

    private int x;
    private int y;
    private char direction;
    private final char[] directions;

    public MarsRover(int x_coordinate, int y_coordinate, char direction) {
        this.x = x_coordinate;
        this.y = y_coordinate;
        this.direction = direction;
        this.directions = new char[]{'N', 'W', 'S', 'E'};

    }

    public String move(String instructions, int[] boundary) {

        MarsRover newPosition = this;
        for (int j = 0; j < instructions.length(); j++) {
            char instruction = instructions.charAt(j);

            if (instruction == 'L' || instruction == 'R') {
                newPosition = findNewDirection(instruction, newPosition);
            } else if (instruction == 'M') {
                newPosition = findNextPosition(newPosition, boundary);
            }
        }
        updateRoverPosition(newPosition);
        return x + " " + y + " " + direction;
    }

    private void updateRoverPosition(MarsRover newPosition) {
        this.x = newPosition.x;
        this.y = newPosition.y;
        this.direction = newPosition.direction;
    }

    private MarsRover findNextPosition(MarsRover newPosition, int[] boundary) {
        int[][] nextPositionAfterMove = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == newPosition.direction) {
                if (roverInsideBoundary(newPosition, nextPositionAfterMove[i], boundary)) {
                    return new MarsRover(newPosition.x + nextPositionAfterMove[i][0], newPosition.y + nextPositionAfterMove[i][1], newPosition.direction);
                }
                return new MarsRover(newPosition.x, newPosition.y, newPosition.direction);

            }
        }
        return null;
    }

    private boolean roverInsideBoundary(MarsRover newPosition, int[] nextPosition, int[] boundary) {
        if (newPosition.x + nextPosition[0] > boundary[0] || newPosition.y + nextPosition[1] > boundary[1]) {
            return false;
        }
        if (newPosition.x + nextPosition[0] < 0 || newPosition.y + nextPosition[1] < 0) {
            return false;
        }
        return true;
    }

    private MarsRover findNewDirection(char instruction, MarsRover newPosition) {
        if (instruction == 'L') {
            for (int i = 0; i < directions.length; i++) {
                if (directions[i] == newPosition.direction) {
                    return new MarsRover(newPosition.x, newPosition.y, directions[(i + 1) % directions.length]);
                }
            }

        } else if (instruction == 'R') {

            for (int i = 0; i < directions.length; i++) {
                if (directions[i] == newPosition.direction) {
                    int index = (i - 1) < 0 ? directions.length - 1 : i - 1;
                    return new MarsRover(newPosition.x, newPosition.y, directions[index]);
                }
            }
        }
        return null;
    }


}
