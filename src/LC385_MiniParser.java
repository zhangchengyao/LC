import java.util.List;

public class LC385_MiniParser {
    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger(){}

        // Constructor initializes a single integer.
        public NestedInteger(int value){}

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger(){return true;}

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger(){return 1;}

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value){}

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni){}

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){return null;}
    }

    public NestedInteger deserialize(String s) {
        if(s.indexOf('[')<0) return new NestedInteger(Integer.parseInt(s));

        NestedInteger ni = new NestedInteger();
        int i = 1;
        while(i<s.length()-1){
            int j = i+1;
            if(s.charAt(i)=='['){
                j = getRightSquareBracket(s, i)+1;
            } else {
                while(j<s.length()-1 && Character.isDigit(s.charAt(j))) j++;
            }
            ni.add(deserialize(s.substring(i, j)));
            i = j+1;
        }

        return ni;
    }

    private int getRightSquareBracket(String s, int start){
        int cnt = 1;
        int i = start+1;
        while(i<s.length() && cnt!=0){
            if(s.charAt(i)=='[') cnt++;
            else if(s.charAt(i)==']') cnt--;
            i++;
        }
        return i-1;
    }

}

