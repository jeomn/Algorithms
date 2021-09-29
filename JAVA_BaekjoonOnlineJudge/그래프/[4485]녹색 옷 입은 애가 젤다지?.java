import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static final int INF = 100000000;
	static int N;
	static int[][] cave;
	static int[][] route;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static class Node implements Comparable<Node>{
		int x, y, w;
		Node(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			t++;
			
			cave = new int[N][N];
			route = new int[N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					cave[r][c] = Integer.parseInt(st.nextToken());
					route[r][c] = INF;
				}
			}
			
			findRoute();
			System.out.printf("Problem %d: %d%n", t, route[N-1][N-1]);
		}
	}

	private static void findRoute() {
		PriorityQueue<Node> path = new PriorityQueue<>();
		route[0][0] = cave[0][0];
		path.offer(new Node(0, 0, cave[0][0]));
		
		while(!path.isEmpty()) {
			Node n = path.poll();
			
			for(int d=0; d<4; d++) {
				int nr = n.x+dx[d];
				int nc = n.y+dy[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(route[nr][nc] > route[n.x][n.y]+cave[nr][nc]) {
					route[nr][nc] = route[n.x][n.y]+cave[nr][nc];
					path.offer(new Node(nr, nc, route[nr][nc]));
				}
			}
		}
	}
}
