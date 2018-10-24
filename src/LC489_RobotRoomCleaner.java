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
    HashSet<String> visited = new HashSet<>();
    int[] dirX = new int[]{-1, 0, 1, 0};
    int[] dirY = new int[]{0, 1, 0, -1};
    int x = 0;
    int y = 0;
    int dir = 0;
    public void cleanRoom(Robot robot) {
        String pos = x+" "+y;
        if(visited.contains(pos)) return ;
        visited.add(pos);
        robot.clean();
        for(int i=0;i<4;i++){
            if(robot.move()){
                x += dirX[dir];
                y += dirY[dir];
                cleanRoom(robot);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                x -= dirX[dir];
                y -= dirY[dir];
                robot.turnLeft();
            }
            else robot.turnRight();
            dir = (dir+1)%4;
        }
    }
}
