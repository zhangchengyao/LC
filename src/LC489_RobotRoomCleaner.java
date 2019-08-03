import java.util.HashSet;

public class LC489_RobotRoomCleaner {
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        public boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        public void turnLeft();
        void turnRight();

        // Clean the current cell.
         public void clean();
    }
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int x = 0;
    private int y = 0;
    private int curDir = 0;
    private HashSet<String> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        String pos = x + " " + y;
        if(visited.contains(pos)) {
            return ;
        }
        visited.add(pos);
        robot.clean();

        for(int i = 0; i < 4; i++) {
            int[] direction = directions[curDir];
            if(robot.move()) {
                x += direction[0];
                y += direction[1];
                cleanRoom(robot);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                x -= direction[0];
                y -= direction[1];
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
            curDir = (curDir + 1) % 4;
        }
    }
}
