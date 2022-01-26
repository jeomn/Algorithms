//2021 카카오 채용연계형 인턴십
//20211007

class Solution {
    
    static char[][] waitingRoom;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] checkUDLR = {0, 2, 4, 6};
    static int[] checkDiagonal = {1, 3, 5, 7};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            waitingRoom = new char[5][5];
            for(int r=0; r<5; r++){
                waitingRoom[r] = places[i][r].toCharArray();
            }
            
            boolean flag = true;
            check: for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(waitingRoom[r][c] != 'P') continue;
                    boolean result = isSocialDistancing(r, c);
                    if(!result){
                        flag = false;
                        break check;
                    }
                }
            }
            answer[i] = (flag)? 1:0;
        }
        return answer;
    }
    
    public boolean isSocialDistancing(int x, int y){
        for(int i=0; i<4; i++){
            //상하좌우
            int nx = x+dx[checkUDLR[i]];
            int ny = y+dy[checkUDLR[i]];
            
            if(nx<0 || nx>=5 || ny<0 ||ny>=5) continue;
            if(waitingRoom[nx][ny] == 'X') continue;
            if(waitingRoom[nx][ny] == 'P') return false;
            
            nx += dx[checkUDLR[i]];
            ny += dy[checkUDLR[i]];
            if(nx<0 || nx>=5 || ny<0 ||ny>=5) continue;
            if(waitingRoom[nx][ny] == 'P') return false;
            
            //대각선
            nx = x+dx[checkDiagonal[i]];
            ny = y+dy[checkDiagonal[i]];
            
            if(nx<0 || nx>=5 || ny<0 ||ny>=5) continue;
            if(waitingRoom[nx][ny] != 'P') continue;
            
            int sx1 = x+dx[checkUDLR[i]];
            int sy1 = y+dy[checkUDLR[i]];
            int sx2 = x+dx[checkUDLR[(i+1)%4]];
            int sy2 = y+dy[checkUDLR[(i+1)%4]];
            
            if(waitingRoom[sx1][sy1] == 'X' && waitingRoom[sx1][sy1]==waitingRoom[sx2][sy2]) continue;
            else return false;
        }
        
        return true;
    }
}






//20220126
class Solution {
    
    char[][] place;
    int[][] dirc = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] dircNext = new int[][]{{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[]{1, 1, 1, 1, 1};
        
        for(int i=0; i<5; i++){
            place = new char[5][5];
            for(int j=0; j<5; j++){
                place[j] = places[i][j].toCharArray();
            }
            check: for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(place[r][c] != 'P') continue;
                    if(!checkDistance(r, c)){
                        answer[i] = 0;
                        break check;
                    }
                }
            }          
        } 
        return answer;
    }
    
    public boolean checkDistance(int r, int c){
        for(int d=0; d<4; d++){
            int nr = r+dirc[d][0];
            int nc = c+dirc[d][1];
            if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
            if(place[nr][nc] == 'P') return false;
            else if(place[nr][nc] == 'X') continue;
            else{
                int nnr = nr+dirc[d][0];
                int nnc = nc+dirc[d][1];
                if(nnr<0 || nnr>=5 || nnc<0 || nnc>=5) continue;
                if(place[nnr][nnc] == 'P') return false;
                
            }
        }
        
        for(int d=0; d<4; d++){
            int nr = r+dircNext[d][0];
            int nc = c+dircNext[d][1];
            if(nr<0 || nr>=5 || nc<0 || nc>=5) continue;
            if(place[nr][nc] != 'P') continue;
            
            int nsx1 = r+dirc[d][0];
            int nsy1 = c+dirc[d][1];
            int nsx2 = r+dirc[(d+1)%4][0];
            int nsy2 = c+dirc[(d+1)%4][1];
            if(place[nsx1][nsy1]=='X' && place[nsx2][nsy2]=='X') continue;
            else return false;
        }
        return true;
    }

}
