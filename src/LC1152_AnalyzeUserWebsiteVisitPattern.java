import java.util.*;

public class LC1152_AnalyzeUserWebsiteVisitPattern {
    static class Visit {
        int timestamp;
        String website;
        Visit(int _timestamp, String _website) {
            timestamp = _timestamp;
            website = _website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Visit>> map = new HashMap<>();
        for(int i = 0; i < username.length; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Visit(timestamp[i], website[i]));
        }

        HashMap<String, Integer> freqMap = new HashMap<>();
        for(List<Visit> visits: map.values()) {
            visits.sort(Comparator.comparingInt(a -> a.timestamp));
            HashSet<String> visited = new HashSet<>();
            for(int i = 0; i < visits.size() - 2; i++) {
                for(int j = i + 1; j < visits.size() - 1; j++) {
                    for(int k = j + 1; k < visits.size(); k++) {
                        String sequence = String.format("%s %s %s", visits.get(i).website, visits.get(j).website, visits.get(k).website);
                        if(visited.contains(sequence)) continue;
                        freqMap.put(sequence, freqMap.getOrDefault(sequence, 0) + 1);
                        visited.add(sequence);
                    }
                }
            }
        }

        String mostFreqSeq = "z";
        int freq = 0;
        for(String seq: freqMap.keySet()) {
            if(freqMap.get(seq) > freq) {
                mostFreqSeq = seq;
                freq = freqMap.get(seq);
            } else if(freqMap.get(seq) == freq && seq.compareTo(mostFreqSeq) < 0) {
                mostFreqSeq = seq;
            }
        }

        return Arrays.asList(mostFreqSeq.split(" "));
    }
}
