public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int dirX = 0, dirY = 1; // pointing north
        int x = 0, y= 0;
        for (char ch : instructions.toCharArray()) {
            if(ch == 'G') {
                x += dirX;
                y += dirY;
            } else if (ch == 'L') {
                int tmp = dirX;
                dirX = -1 * dirY;
                dirY = tmp;
            } else {
                int tmp = dirY;
                dirY = -1 * dirX;
                dirX = tmp;
            }
        }
        return (x == 0 && y == 0) || (dirX != 0 || dirY != 1);
    }

    public static void main(String[] args) {
        RobotBoundedInCircle solution = new RobotBoundedInCircle();
        String instructions = "GGLLGG";
        boolean result = solution.isRobotBounded(instructions);
        System.out.println(result);
    }
}
