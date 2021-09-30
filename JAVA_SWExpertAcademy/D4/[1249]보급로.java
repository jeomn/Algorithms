import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
	
	static final int INF = 1_000_000_000;
	static int N;
	static int[][] map, cost;
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
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cost = new int[N][N];
			for(int r=0; r<N; r++) {
				char[] temp = br.readLine().toCharArray();
				for(int c=0; c<N; c++) {
					map[r][c] = temp[c]-'0';
					cost[r][c] = INF;
				}
			}
			
			System.out.printf("#%d %d%n", test, findRoute());
		}
	}

	private static int findRoute() {
		PriorityQueue<Node> route = new PriorityQueue<>();
		route.offer(new Node(0, 0, 0));
		cost[0][0] = 0;
		
		int nr, nc;
		while(!route.isEmpty()) {
			Node node = route.poll();
			if(node.x==N-1 && node.y==N-1) return cost[N-1][N-1];
			
			for(int d=0; d<4; d++) {
				nr = node.x+dx[d];
				nc = node.y+dy[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(cost[nr][nc] <= cost[node.x][node.y]+map[nr][nc]) continue;
				
				cost[nr][nc] = cost[node.x][node.y]+map[nr][nc];
				route.add(new Node(nr, nc, cost[nr][nc]));
			}
		}
		
		return 0;
	}
}
