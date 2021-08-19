import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int R, C, maxCnt;
	static char[][] board;
	static boolean[] visited  = new boolean[26];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for(int r=0; r<R; r++) {
			board[r] = br.readLine().toCharArray();
		}
		
		maxCnt = -1;
		visited[board[0][0]-65] = true;
		findRoute(0, 0, 1);
		System.out.println(maxCnt);
		
	}
	
	
	private static void findRoute(int x, int y, int cnt) {
		
		boolean flag = false;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0|| nx>=R || ny<0 ||ny>=C) continue;
			if(visited[board[nx][ny]-65]) continue;
			
			flag = true;
			visited[board[nx][ny]-65] = true;
			findRoute(nx, ny, cnt+1);
			visited[board[nx][ny]-65] = false;
		}
		if(!flag) maxCnt = Math.max(maxCnt, cnt);
	}
}
