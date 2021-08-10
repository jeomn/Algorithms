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
