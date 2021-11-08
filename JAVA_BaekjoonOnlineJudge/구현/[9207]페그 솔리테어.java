import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	static int minPinCnt, minMoveCnt;
	static char[][] board;
	static Node[] pins;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node {
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			board = new char[5][9];
			pins = new Node[8];
			int pIdx = 0;
			for(int r=0; r<5; r++) {
				String temp = br.readLine();
				for(int c=0; c<9; c++) {
					char ch = temp.charAt(c);
					board[r][c] = ch;
					if(ch == 'o') {
						pins[pIdx++] = new Node(r, c);
					}
				}
			}
			
			minPinCnt = 8;
			minMoveCnt = 0;
			movePins(0, pIdx);

			System.out.println(minPinCnt+" "+minMoveCnt);
			T--;
			if(T>0) br.readLine();
		}
		
			
	}

	private static void movePins(int cnt, int pNum) {
		for(int r=0; r<5; r++) {
			for(int c=0; c<9; c++) {
				if(board[r][c] != 'o') continue;
				
				for(int d=0; d<4; d++) {
					int nr = r+dx[d];
					int nc = c+dy[d];
					
					if(nr<0 || nr>=5 || nc<0 || nc>=9) continue;
					if(board[nr][nc] != 'o') continue;
					
					int nnr = nr+dx[d];
					int nnc = nc+dy[d];
					
					if(nnr<0 || nnr>=5 || nnc<0 || nnc>=9) continue;
					if(board[nnr][nnc] != '.') continue;
					
					board[r][c] = '.';
					board[nr][nc] = '.';
					board[nnr][nnc] = 'o';
					movePins(cnt+1, pNum-1);
					
					board[r][c] = 'o';
					board[nr][nc] = 'o';
					board[nnr][nnc] = '.';
				}
			}
		}
		
		minMoveCnt = Math.max(minMoveCnt, cnt);
		minPinCnt = Math.min(minPinCnt, pNum);
	}
}
