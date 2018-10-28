public class LC79_WordSearch {
    public boolean exist(char[][] board, String word){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(exist(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, int i, int j, String word, int start){
        if(start==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(board[i][j]!=word.charAt(start)){
            return false;
        }
        board[i][j] = '*';
        boolean res =   exist(board, i-1, j, word, start+1) ||
                        exist(board, i+1, j, word, start+1) ||
                        exist(board, i, j-1, word, start+1) ||
                        exist(board, i, j+1, word, start+1);
        board[i][j] = word.charAt(start);
        return res;
    }
//    class Item{
//        Stack<Item> stack;
//        int x;
//        int y;
//        Item(int i, int j){
//            stack = new Stack<>();
//            x = i;
//            y = j;
//        }
//        public boolean equals(Object object){
//            if(!(object instanceof Item)){
//                return false;
//            }
//            Item another = (Item)object;
//            return (x==another.x && y==another.y);
//        }
//    }
//    public boolean exist(char[][] board, String word) {
//        if(word.equals(""))
//            return true;
//        ArrayList<Item> path = new ArrayList<>();
//        Stack<Item> stack = new Stack<>();
//        int rows = board.length;
//        int columns = board[0].length;
//        while(path.size()!=word.length()){
//            int len = path.size();
//            if(len==0){
//                //处理第一个字母，遍历整个board
//                for(int i=0;i<rows;i++){
//                    for(int j=0;j<columns;j++){
//                        if(board[i][j]==word.charAt(len)){
//                            stack.push(new Item(i, j));
//                        }
//                    }
//                }
//                if(stack.isEmpty()){
//                    return false;
//                }
//                path.add(stack.pop());
//            }else{
//                Item item = path.get(len-1);
//                char c = word.charAt(len);
//                int posX = item.x;
//                int posY = item.y;
//                boolean pushed = false;
//                if(posX-1>=0 && board[posX-1][posY]==c){
//                    Item it = new Item(posX-1, posY);
//                    if(!path.contains(it)){
//                        item.stack.push(it);
//                        pushed = true;
//                    }
//                }
//                if(posX+1<rows && board[posX+1][posY]==c){
//                    Item it = new Item(posX+1, posY);
//                    if(!path.contains(it)){
//                        item.stack.push(it);
//                        pushed = true;
//                    }
//                }
//                if(posY-1>=0 && board[posX][posY-1]==c){
//                    Item it = new Item(posX, posY-1);
//                    if(!path.contains(it)){
//                        item.stack.push(it);
//                        pushed = true;
//                    }
//                }
//                if(posY+1<columns && board[posX][posY+1]==c){
//                    Item it = new Item(posX, posY+1);
//                    if(!path.contains(it)){
//                        item.stack.push(it);
//                        pushed = true;
//                    }
//                }
//                if(!pushed){
//                    //当前路径不可行
//                    path.remove(len-1);
//                    while(path.size()>0 && path.get(path.size()-1).stack.isEmpty()){
//                        path.remove(path.size()-1);
//                    }
//                    if(path.size()==0){
//                        if(stack.isEmpty()){
//                            return false;
//                        }else{
//                            path.add(stack.pop());
//                        }
//                    }else{
//                        path.add(path.get(path.size()-1).stack.pop());
//                    }
//                }else{
//                    //当前路径可以继续扩展
//                    path.add(item.stack.pop());
//                }
//            }
//        }
//        return true;
//    }
}
