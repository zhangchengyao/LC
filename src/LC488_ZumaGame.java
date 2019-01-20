import java.util.HashMap;

public class LC488_ZumaGame {
    public int findMinStep(String board, String hand) {
        return findMinStep(board, hand, new HashMap<>());
    }

    private int findMinStep(String board, String hand, HashMap<String, Integer> memo){
        if(board.equals("")) return 0;
        if(hand.equals("")) return -1;

        String state = board+" "+hand;
        if(memo.containsKey(state)) return memo.get(state);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<hand.length();i++){
            char ball = hand.charAt(i);
            for(int j=0;j<board.length();j++){
                if(board.charAt(j)==ball){
                    String newBoard = update(board, j, ball);
                    int steps = findMinStep(newBoard, hand.substring(0, i)+hand.substring(i+1), memo);
                    if(steps!=-1){
                        min = Math.min(min, 1+steps);
                    }
                    int end = j+1;
                    while(end<board.length() && board.charAt(end)==ball) end++;
                    j = end;
                }
            }
        }

        memo.put(state, min==Integer.MAX_VALUE?-1:min);
        return memo.get(state);
    }

    private String update(String board, int j, char ball){
        int end = j;
        while(end<board.length() && board.charAt(end)==ball) end++;
        if(end-j>=2){
            StringBuilder newBoard = new StringBuilder();
            newBoard.append(board.substring(0, j)).append(board.substring(end));
            j--;
            if(j>=0 && j<newBoard.length()-1 && newBoard.charAt(j)==newBoard.charAt(j+1)){
                int start = j-1;
                ball = newBoard.charAt(j);
                while(start>=0 && newBoard.charAt(start)==ball){
                    start--;
                }
                newBoard.deleteCharAt(start+1);
                return update(newBoard.toString(), start+1, ball);
            } else {
                return newBoard.toString();
            }
        } else {
            StringBuilder sb = new StringBuilder(board);
            sb.insert(j, ball);
            return sb.toString();
        }
    }
}
