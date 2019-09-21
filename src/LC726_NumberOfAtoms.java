import java.util.TreeMap;

public class LC726_NumberOfAtoms {
    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> tmap = new TreeMap<>();
        count(tmap, formula, 1);

        StringBuilder sb = new StringBuilder();
        for(String atom: tmap.keySet()) {
            sb.append(atom);
            if(tmap.get(atom) > 1) sb.append(tmap.get(atom));
        }

        return sb.toString();
    }

    private void count(TreeMap<String, Integer> tmap, String formula, int factor) {
        for(int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if(Character.isLetter(c)) {
                int j = i + 1;
                while(j < formula.length() && Character.isLowerCase(formula.charAt(j))) j++;
                String atom = formula.substring(i, j);
                if(j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    int k = j + 1;
                    while(k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                    int cnt = Integer.parseInt(formula.substring(j, k));
                    tmap.put(atom, tmap.getOrDefault(atom, 0) + cnt * factor);
                    i = k - 1;
                } else {
                    tmap.put(atom, tmap.getOrDefault(atom, 0) + factor);
                    i = j - 1;
                }
            } else {
                // left parenthesis
                int cnt = 1;
                int j = i + 1;
                while(cnt > 0) {
                    if(formula.charAt(j) == '(') cnt++;
                    else if(formula.charAt(j) == ')') cnt--;
                    j++;
                }
                if(Character.isDigit(formula.charAt(j))) {
                    int k = j + 1;
                    while(k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                    int num = Integer.parseInt(formula.substring(j, k));
                    count(tmap, formula.substring(i + 1, j - 1), factor * num);
                    i = k - 1;
                } else {
                    count(tmap, formula.substring(i + 1, j - 1), factor);
                    i = j - 1;
                }
            }
        }
    }
}
