public class LC286_WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0) return;
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    probe(rooms, i-1, j, 1);
                    probe(rooms, i+1, j, 1);
                    probe(rooms, i, j-1, 1);
                    probe(rooms, i, j+1, 1);
                }
            }
        }
    }
    private void probe(int[][] rooms, int x, int y, int dis){
        if(x<0 || x>=rooms.length || y<0 || y>=rooms[0].length) return;
        if(rooms[x][y]==-1 || rooms[x][y]==0) return;
        if(rooms[x][y]<=dis) return;
        else rooms[x][y] = dis;
        probe(rooms, x-1, y, dis+1);
        probe(rooms, x+1, y, dis+1);
        probe(rooms, x, y-1, dis+1);
        probe(rooms, x, y+1, dis+1);
    }
}
