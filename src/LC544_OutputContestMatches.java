import java.util.ArrayList;
import java.util.List;

public class LC544_OutputContestMatches {
    public String findContestMatch(int n) {
        List<String> teams = new ArrayList<>();
        for(int i=1;i<=n;i++) teams.add(i+"");
        return match(teams);
    }
    private String match(List<String> teams){
        if(teams.size()==2) return "("+teams.get(0)+","+teams.get(1)+")";
        List<String> newTeams = new ArrayList<>();
        for(int i=0;i<teams.size()/2;i++){
            newTeams.add("("+teams.get(i)+","+teams.get(teams.size()-i-1)+")");
        }
        return match(newTeams);
    }
}
