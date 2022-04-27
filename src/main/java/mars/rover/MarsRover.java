package mars.rover;


public class MarsRover {

    private final int x;
    private final int y;
    private final char direction;


    public MarsRover(int x_coordinate, int y_coordinate, char direction) {
        this.x = x_coordinate;
        this.y = y_coordinate;
        this.direction = direction;

    }

    public static String move(int x, int y, char direction, String instructions) {
        char newDirection = ' ';
        char[] directions = {'N', 'W', 'S', 'E'};

        if (!instructions.isEmpty()) {
            char instruction = instructions.charAt(0);
            if (instruction == 'L') {
                for (int i = 0; i < directions.length; i++) {
                    if (directions[i] == direction) {
                        int index = (i + 1) % directions.length;
                        newDirection = directions[index];
                    }
                }
                return move(x, y, newDirection, instructions.substring(1, instructions.length()));
            } else if (instruction == 'R') {
                for (int i = 0; i < directions.length; i++) {
                    if (directions[i] == direction) {
                        int index = (i - 1) < 0 ? directions.length - 1 : i - 1;
                        newDirection = directions[index];
                    }
                }
                return move(x, y, newDirection, instructions.substring(1, instructions.length()));
            } else if (instruction == 'M') {
                if (direction == 'N') {
                    return move(x, y + 1, 'N', instructions.substring(1, instructions.length()));
                } else if (direction == 'S') {
                    return move(x, y - 1, 'S', instructions.substring(1, instructions.length()));
                } else if (direction == 'W') {
                    return move(x - 1, y, 'W', instructions.substring(1, instructions.length()));
                } else if (direction == 'E') {
                    return move(x + 1, y, 'E', instructions.substring(1, instructions.length()));
                }
            }
        }
        return x + " " + y + " " + direction;
    }
}
