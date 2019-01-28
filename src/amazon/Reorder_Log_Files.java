package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reorder_Log_Files {
    static class Log{
        String id;
        String val;
        Log(String _id, String _val){
            id = _id;
            val = _val;
        }
    }

    public static List<String> logFiles(int logFileSize, List<String> logLines){
        List<String> logNumbers = new ArrayList<>();
        List<Log> logLetters = new ArrayList<>();
        for(String line: logLines){
            int idx = line.indexOf(' ');
            if(Character.isDigit(line.charAt(idx+1))){
                logNumbers.add(line);
            } else {
                logLetters.add(new Log(line.substring(0, idx), line.substring(idx+1)));
            }
        }

        Collections.sort(logLetters, (x,y) -> x.val.equals(y.val)?x.id.compareTo(y.id):x.val.compareTo(y.val));

        List<String> res = new ArrayList<>();
        for(Log log: logLetters){
            res.add(log.id + " "+ log.val);
        }
        res.addAll(logNumbers);

        return res;
    }

    public static void main(String[] args){
        List<String> logLines = new ArrayList<>();
        logLines.add("a1 9 2 3 1");
        logLines.add("g1 act car");
        logLines.add("zo4 4 7");
        logLines.add("ab1 off key dog");
        logLines.add("a8 act zoo");
        System.out.println(logFiles(5, logLines));
    }
}
