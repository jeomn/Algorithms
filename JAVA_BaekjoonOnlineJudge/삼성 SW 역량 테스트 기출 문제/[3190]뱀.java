import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] field;
	static int N, d, time;
	static Deque<int[]> snake;
	static HashMap<Integer, String> command;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		field = new int[N][N];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			field[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 3;
		}
		
		snake = new LinkedList<>();
		snake.add(new int[] {0, 0});
		d = 1;
		field[0][0] = 1;
		
		int L = Integer.parseInt(br.readLine());
		command = new HashMap<>();
		for(int l=0; l<L; l++) {
			st = new StringTokenizer(br.readLine());
			command.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		moveSnake();
		System.out.println(time);
	}

	private static void moveSnake() {
		
		int nr = 0;
		int nc = 0;
		
		while(true) {
			time++;
			
			nr +=dx[d];
			nc +=dy[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N) return;
			
			int next = field[nr][nc];
			if(next == 3) {
				field[nr][nc] = 1;
			}else if(next == 0) {
				field[nr][nc] = 1;
				int[] scoord = snake.pollLast();
				field[scoord[0]][scoord[1]] = 0;
			}else {
				return;
			}
			
			snake.addFirst(new int[] {nr, nc});
			String dirc = command.getOrDefault(time, null);
			if(dirc != null) {
				d=dirc.equals("L") ? (d+3)%4:(d+1)%4;
			}
		}
	}
}


/****************
*	20211001
*	
*****************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static Deque<int[]> snake;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		Queue<int[]> order = new LinkedList<>();
		for(int l=0; l<L; l++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			int c = (C.equals("D"))? 1:-1;
			order.add(new int[] {X, c});
		}
		
		board[0][0] = 1;
		snake = new LinkedList<>();
		snake.add(new int[] {0, 0});
		int time = 0, r = 0, c = 0, d = 1, cTime = 0;
		boolean command = true;
		int[] o = new int[2];
		while(true) {
			if(command && !order.isEmpty()) {
				o = order.poll();
				cTime = o[0];
				command = false;
			}
			
			time++;
			r += dx[d];
			c += dy[d];
			
			if(r<0 || r>=N || c<0 || c>=N || board[r][c] == 1) break;
			if(board[r][c] != 2) {
				int[] tail = snake.poll();
				board[tail[0]][tail[1]] = 0;
			}
			board[r][c] = 1;
			snake.addLast(new int[] {r, c});
			
			if(time == cTime) {
				command = true;
				d = ((d+o[1])+4)%4;
			}
		}

		System.out.println(time);
	}

}

