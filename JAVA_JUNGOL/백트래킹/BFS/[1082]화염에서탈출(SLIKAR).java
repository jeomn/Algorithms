import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char[][] map;
	static boolean[][] isFire;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isFire = new boolean[R][C];
		Node start = null;
		for(int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				char temp = map[r][c];
				if(temp == 'S') {
					start = new Node(r, c, 0);
				}else if(temp == '*') {
					isFire[r][c] = true;
				}
			}
		}
		
		int result = findRoute(start);
		if(result == -1) System.out.println("impossible");
		else System.out.println(result);
	}

	private static int findRoute(Node start) {
		Queue<Node> route = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		route.add(start);
		visited[start.x][start.y] = true;
		int time = 1;
		
		while(!route.isEmpty()) {
			Node n = route.poll();
			if(map[n.x][n.y] == 'D') return n.t;
			
			if(n.t == 0) {
				spreadFire();
			}else if(n.t == time) {
				spreadFire();
				time++;		
			}

			for(int d=0; d<4; d++) {
				int nr = n.x+dx[d];
				int nc = n.y+dy[d];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(visited[nr][nc] || isFire[nr][nc] || map[nr][nc] == 'X') continue;
				
				route.add(new Node(nr, nc, n.t+1));
				visited[nr][nc] = true;
			}
		}
		
		return -1;
	}

	private static void spreadFire() {
		boolean[][] fireTemp = new boolean[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(!isFire[r][c]) continue;
				
				fireTemp[r][c] = true;
				for(int d=0; d<4; d++) {
					int nr = r+dx[d];
					int nc = c+dy[d];
					
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if(isFire[nr][nc] || map[nr][nc] == 'D' || map[nr][nc] == 'X')  continue;
					fireTemp[nr][nc] = true;
				}
			}
		}
		isFire = fireTemp;
		
	}
}
