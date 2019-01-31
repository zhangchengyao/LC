import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC957_PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N==0) return cells;

        List<Integer> states = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        // 1 -> 0, denote as -1
        // 0 -> 1, denote as 2
        for(int day=1;day<=N;day++){
            for(int i=1;i<cells.length-1;i++){
                if( ((cells[i-1]==0||cells[i-1]==2) && (cells[i+1]==0||cells[i+1]==2)) ||
                        ((cells[i-1]==1||cells[i-1]==-1) && (cells[i+1]==1||cells[i+1]==-1)) ){
                    if(cells[i]==0) cells[i] = 2;
                } else {
                    if(cells[i]==1) cells[i] = -1;
                }
            }

            for(int i=1;i<cells.length-1;i++){
                if(cells[i]==-1) cells[i] = 0;
                else if(cells[i]==2) cells[i] = 1;
            }

            cells[0] = 0;
            cells[cells.length-1] = 0;

            int state = getState(cells);
            if(set.contains(state)) break;
            else{
                states.add(state);
                set.add(state);
            }
        }


        if(states.size()==N) return cells;
        else {
            int finalState = states.get((N-1) % states.size());
            for(int i=0;i<cells.length;i++){
                int val = (finalState>>i) & 1;
                cells[cells.length-1-i] = val;
            }
            return cells;
        }
    }

    private int getState(int[] cells){
        int state = 0;
        for(int i=0;i<cells.length;i++){
            int mask = cells[i] & 1;
            state |= (mask << cells.length-1-i);
        }
        return state;
    }
}
