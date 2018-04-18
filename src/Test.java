public class Test {
    public static void main(String[] args){
        char[][] board = new char[3][4];
//        board[0][0] = 'a';
//        board[0][1] = 'a';
        String chars = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                board[i][j] = chars.charAt((int)(Math.random()*26));
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        String word = "ABC";
        LC79_WordSearch lc79_wordSearch = new LC79_WordSearch();
        System.out.println(lc79_wordSearch.exist(board,word));
    }
}
