import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K, W, H, minCnt;
	static int[][] world;
	static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node{
		int x;
		int y;
		int k;
		int d;
		Node(int x, int y, int k, int d){
			this.x = x;
			this.y = y;
			this.k = k;
			this.d = d;
		}
	}
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		world = new int[H][W];
		for(int r=0; r<H; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<W; c++) {
				world[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = findRoute(0, 0);
		System.out.println(cnt);
	}

	private static int findRoute(int x, int y) {
		Queue<Node> route = new LinkedList<>();
		boolean[][][] visited = new boolean[H][W][K+1];
		route.add(new Node(x, y, K, 0));
		visited[0][0][0] = true;
		
		while(!route.isEmpty()) {
			Node node = route.poll();
			int r = node.x;
			int c = node.y;
			int k = node.k;
			
			if(r==H-1 && c==W-1) return node.d;
			
			for(int idx=0; idx<4; idx++) {
				int nr = r+dx[idx];
				int nc = c+dy[idx];
				
				if(nr<0 || nr>=H || nc<0 || nc>=W) continue;
				if(visited[nr][nc][k] || world[nr][nc] == 1) continue;
				
				route.add(new Node(nr, nc, k, node.d+1));
				visited[nr][nc][k] = true; 
			}
			if(k != 0) {
				for(int idx=0; idx<8; idx++) {
					int nr = r+hx[idx];
					int nc = c+hy[idx];
					
					if(nr<0 || nr>=H || nc<0 || nc>=W) continue;
					if(visited[nr][nc][k-1] || world[nr][nc] == 1) continue;
					
					route.add(new Node(nr, nc, k-1, node.d+1));
					visited[nr][nc][k-1] = true;
				}
			}
		}
		return -1;
	}
}
