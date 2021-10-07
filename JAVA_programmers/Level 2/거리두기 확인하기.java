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
        //상하좌우 탐색
        for(int i=0; i<4; i++){
            int nx = x+dx[checkUDLR[i]];
            int ny = y+dy[checkUDLR[i]];
            
            if(nx<0 || nx>=5 || ny<0 ||ny>=5) continue;
            if(waitingRoom[nx][ny] == 'X') continue;
            if(waitingRoom[nx][ny] == 'P') return false;
            
            nx += dx[checkUDLR[i]];
            ny += dy[checkUDLR[i]];
            if(nx<0 || nx>=5 || ny<0 ||ny>=5) continue;
            if(waitingRoom[nx][ny] == 'P') return false;
        }
        
        
        //대각선 확인
        for(int i=0; i<3; i++){
            int nx = x+dx[checkDiagonal[i]];
            int ny = y+dy[checkDiagonal[i]];
            
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
