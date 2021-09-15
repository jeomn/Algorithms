import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] field;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				field[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int meltedCnt = 0, time = 0;
		while(true) {
			
			int meltCnt = findCheeseEdge(0, 0);
			if(meltCnt == 0) {
				break;
			}
			time++;
			meltedCnt = meltCnt;
		}
		System.out.println(time);
		System.out.println(meltedCnt);
	}

	private static int findCheeseEdge(int x, int y) {
		Queue<int[]> route = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		route.add(new int[] {x, y});
		visited[x][y] = true;
		
		int cnt = 0;
		while(!route.isEmpty()) {
			int[] node = route.poll();
			int r = node[0];
			int c = node[1];
			
			for(int idx=0; idx<4; idx++) {
				int nr = r+dx[idx];
				int nc = c+dy[idx];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(visited[nr][nc]) continue;
				if(field[nr][nc] == 0) {
					route.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}else if(field[nr][nc] == 1) {
					field[nr][nc] = 2;
					cnt++;
				}
			}
		}
		if(cnt != 0) meltCheese();
		return cnt;
	}

	private static void meltCheese() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(field[r][c] == 2) field[r][c] = 0;
			}
		}
	}
}
