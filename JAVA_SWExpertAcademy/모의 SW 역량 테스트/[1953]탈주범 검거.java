import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {
	
	static int N, M, R, C, L, cntPlace;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] tunnelConnection = {
			{0, 0, 0, 0},
			{1, 1, 1, 1},
			{1, 0, 1 ,0},
			{0, 1, 0, 1},
			{1, 0, 0, 1},
			{0, 0, 1, 1},
			{0, 1, 1, 0},
			{1, 1, 0, 0}};
	static class Node{
		int x, y, t;
		Node(int x, int y, int t){
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			cntPlace = 1;
			countRoute();
			
			System.out.println("#"+test+" "+cntPlace);
		}
	}

	private static void countRoute() {
		Queue<Node> route = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		route.add(new Node(R, C, 1));
		visited[R][C] = true;
		
		int cnt = 0;
		while(!route.isEmpty()) {
			Node node = route.poll();
			if(node.t == L) return;
			
			int currTunnel = map[node.x][node.y];
			int[] d = tunnelConnection[currTunnel];
			for(int idx=0; idx<4; idx++) {
				if(d[idx] == 0) continue;
				int nr = node.x+dx[idx];
				int nc = node.y+dy[idx];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(visited[nr][nc] || map[nr][nc] == 0) continue;
				if(tunnelConnection[map[nr][nc]][(idx+2)%4] == 0) continue;
				
				route.add(new Node(nr, nc, node.t+1));
				visited[nr][nc] = true;
				cntPlace++;
			}
		}
	}

}
