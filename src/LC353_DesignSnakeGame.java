import java.util.HashSet;
import java.util.LinkedList;

public class LC353_DesignSnakeGame {
    private int width;
    private int height;
    private int[][] food;
    private LinkedList<int[]> snake;
    private HashSet<Integer> body;
    private int score;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public LC353_DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<>();
        snake.offer(new int[]{0, 0});
        body = new HashSet<>();
        body.add(0);
        score = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] tail = snake.peek();
        int[] head = snake.peekLast();
        int r, c;
        switch (direction) {
            case "U":
                r = head[0] - 1;
                c = head[1];
                break;
            case "L":
                r = head[0];
                c = head[1] - 1;
                break;
            case "R":
                r = head[0];
                c = head[1] + 1;
                break;
            default:
                r = head[0] + 1;
                c = head[1];
                break;
        }

        if(r < 0 || r >= height || c < 0 || c >= width || (body.contains(r * width + c) && !(tail[0] == r && tail[1] == c))) return -1;

        if(score < food.length && food[score][0] == r && food[score][1] == c) {
            score++;
        } else {
            body.remove(tail[0] * width + tail[1]);
            snake.poll();
        }
        snake.offer(new int[]{r, c});
        body.add(r * width + c);

        return score;
    }
}
