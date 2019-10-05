import java.util.HashSet;
import java.util.Set;

public class LC874_WalkingRobotSimulation {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        int dirIdx = 0;
        int r = 0;
        int c = 0;
        Set<String> obs = new HashSet<>();
        for(int[] obstacle: obstacles) {
            obs.add(obstacle[0] + " " + obstacle[1]);
        }

        int maxDist = 0;
        for(int command: commands) {
            if(command == -2) dirIdx = (dirIdx + directions.length - 1) % directions.length;
            else if(command == -1) dirIdx = (dirIdx + 1) % directions.length;
            else {
                while(command > 0) {
                    r += directions[dirIdx][0];
                    c += directions[dirIdx][1];
                    if(obs.contains(r + " " + c)) {
                        r -= directions[dirIdx][0];
                        c -= directions[dirIdx][1];
                        break;
                    }
                    command--;
                }
                maxDist = Math.max(maxDist, r * r + c * c);
            }
        }

        return maxDist;
    }
}
