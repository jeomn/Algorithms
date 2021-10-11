import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node implements Comparable<Node>{
		int x, y, v;
		Node(int x, int y, int v){
			this.x = x;
			this.y = y;
			this.v = v;
		}
		@Override
		public int compareTo(Node o) {
			return o.v - this.v;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = countRoute(0, 0);
		System.out.println(answer);
	}

	private static int countRoute(int i, int j) {
		PriorityQueue<Node> route = new PriorityQueue<>();
		route.add(new Node(i, j, map[i][j]));
		int[][] visited = new int[N][M];
		visited[i][j] = 1;
		
		while(!route.isEmpty()) {
			Node n = route.poll();
			
			for(int d=0; d<4; d++) {
				int nx = n.x+dx[d];
				int ny = n.y+dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny] >= map[n.x][n.y]) continue;
				
				if(visited[nx][ny]==0) route.add(new Node(nx, ny, map[nx][ny]));
				visited[nx][ny] += visited[n.x][n.y];
			}
		}
		return visited[N-1][M-1];
	}
}
