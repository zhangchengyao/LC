import java.util.Comparator;
import java.util.PriorityQueue;

public class LC502_IPO {
    class Project{
        int profit;
        int capital;
        Project(int _profit, int _capital){
            profit = _profit;
            capital = _capital;
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Project> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.capital));
        for(int i=0;i<Profits.length;i++){
            Project project = new Project(Profits[i], Capital[i]);
            pq.offer(project);
        }

        PriorityQueue<Project> cand = new PriorityQueue<>((a,b)->b.profit-a.profit);
        addProjects(pq, cand, W);

        for(int i=0;i<k;i++){
            if(cand.isEmpty()) break;
            Project cur = cand.poll();
            W += cur.profit;
            addProjects(pq, cand, W);
        }

        return W;
    }

    private void addProjects(PriorityQueue<Project> pq, PriorityQueue<Project> cand, int W){
        while(!pq.isEmpty() && pq.peek().capital<=W) cand.offer(pq.poll());
    }
}
