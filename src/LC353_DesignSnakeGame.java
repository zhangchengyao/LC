import java.util.ArrayList;
import java.util.List;

public class LC353_DesignSnakeGame {
    List<int[]> snake;
    int[][] food;
    int score;
    int width;
    int height;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public LC353_DesignSnakeGame(int width, int height, int[][] food) {
        snake = new ArrayList<>();
        this.food = food;
        score = 0;
        this.width = width;
        this.height = height;
        snake.add(new int[]{0, 0});
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = snake.get(0);
        int x = head[0];
        int y = head[1];
        int[] tail = snake.remove(snake.size()-1);
        if(direction.equals("U")) x--;
        else if(direction.equals("L")) y--;
        else if(direction.equals("R")) y++;
        else x++;
        if(x<0 || y<0 || x>=height || y>=width) return -1;
        for(int[] body: snake){
            if(x==body[0] && y==body[1]) return -1;
        }
        if(score<food.length && x==food[score][0] && y==food[score][1]){
            snake.add(tail);
            score++;
        }
        snake.add(0, new int[]{x, y});
        return score;
    }
}
