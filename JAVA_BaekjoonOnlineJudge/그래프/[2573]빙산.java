import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[][] iceberg;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iceberg = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				iceberg[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		while(true) {
			visited = new boolean[N][M];
			int label = 0;
			boolean isIceberg = false;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(iceberg[r][c] == 0) continue;
					if(visited[r][c]) continue;
					isIceberg = countIceberg(r, c);
					label++;
				}
			}
			if(label > 1) {
				System.out.println(year);
				break;
			}
			
			if(!isIceberg) {
				System.out.println(0);
				break;
			}
			
			meltIceberg();
			year++;
		}
	}
	
	
	private static void meltIceberg() {
		int[][] icebergTemp = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(iceberg[r][c] == 0) continue;
				
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int nr = r+dx[d];
					int nc = c+dy[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
					if(iceberg[nr][nc] == 0) cnt++;
				}
				
				icebergTemp[r][c]  = iceberg[r][c] - cnt;
				if(icebergTemp[r][c] < 0) icebergTemp[r][c] = 0;
			}
		}
		iceberg = icebergTemp;
	}
	
	
	private static boolean countIceberg(int x, int y) {
		Deque<Node> route = new LinkedList<Node>();
		route.add(new Node(x, y));
		visited[x][y] = true;
		
		boolean isIceberg = false;
		while(!route.isEmpty()) {
			Node node = route.poll();
			int r = node.x;
			int c = node.y;
			
			for(int d=0; d<4; d++) {
				int nr = r+dx[d];
				int nc = c+dy[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(iceberg[nr][nc]==0 || visited[nr][nc]) continue;
				
				route.add(new Node(nr, nc));
				visited[nr][nc] = true;
				isIceberg = true;
			}
		}
		return isIceberg;
	}
}
