import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
	
	static int N, maxCnt;
	static int[][] board;
	static Deque<Node> mineCandidate;
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static class Node {
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		for(int r=0; r<N; r++) {
			String temp = br.readLine();
			for(int c=0; c<N; c++) {
				char ch = temp.charAt(c);
				if(Character.isDigit(ch)) board[r][c] = ch-'0';
				else board[r][c] = -1;
			}
		}
		
		int num = (N-4<=0)? 0:N-4;
		maxCnt = num*num;
		mineCandidate = new LinkedList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				//첫 줄, 마지막 줄
				if(r==1 || r==N-2) {
					if(board[r][c] == -1) mineCandidate.add(new Node(r, c));
				//중간 줄들
				}else if(r>1 && r<N-2) {
					if(c==1 || c==N-2) mineCandidate.add(new Node(r, c));
				}
			}
		}
		
		setMine();
		System.out.println(maxCnt);
	}

	private static void setMine() {
		pass: while(!mineCandidate.isEmpty()) {
			Node n = mineCandidate.poll();
			
			for(int d=0; d<8; d++) {
				int nr = n.x+dx[d];
				int nc = n.y+dy[d];
				
				if(board[nr][nc] == 0) continue pass;
			}
			
			for(int d=0; d<8; d++) {
				int nr = n.x+dx[d];
				int nc = n.y+dy[d];
				
				if(board[nr][nc] == -1) continue;
				board[nr][nc]--;
			}
			maxCnt++;
		}		
	}
}
