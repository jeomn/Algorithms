import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] grid;
	static boolean[][] visited;
	static boolean[][] rgvisited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node{
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		grid = new char[N][];
		for(int r=0; r<N; r++) {
			grid[r] = br.readLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		rgvisited = new boolean[N][N];
		int rgwCnt = 0, cnt = 0, sectionCnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(visited[r][c]) continue;
				if(grid[r][c] == 'B') {
					rgvisited[r][c] = true;
					sectionCnt = findSection(r, c, grid[r][c]);
					cnt++;
					rgwCnt++;
					
				} else {
					sectionCnt = findSection(r, c, grid[r][c]);
					cnt++;
					sectionCnt = findSectionRG(r, c, grid[r][c]);
					if(sectionCnt != 0)rgwCnt++;
				}
			}
		}
		System.out.println(cnt+" "+rgwCnt);
	}
	
	
	private static int findSection(int x, int y, char color) {
		Queue<Node> route = new LinkedList<>();
		route.add(new Node(x, y));
		visited[x][y] = true;
		int cnt = 1;
		
		while(!route.isEmpty()) {
			Node node = route.poll();
			int r = node.r;
			int c = node.c;
			
			for(int i=0; i<4; i++) {
				int nr = r+dx[i];
				int nc = c+dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(visited[nr][nc]) continue;
				
				if(color == grid[nr][nc]) {
					route.add(new Node(nr, nc));
					visited[nr][nc] = true;
					if(color == 'B') {
						rgvisited[nr][nc] = true;
					}
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	
	private static int findSectionRG(int x, int y, char color) {
		if(rgvisited[x][y]) return 0;
		
		Queue<Node> route = new LinkedList<>();
		route.add(new Node(x, y));
		rgvisited[x][y] = true;
		int cnt = 1;
		
		
		while(!route.isEmpty()) {
			Node node = route.poll();
			int r = node.r;
			int c = node.c;
			
			for(int i=0; i<4; i++) {
				int nr = r+dx[i];
				int nc = c+dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(rgvisited[nr][nc]) continue;
				
				if(grid[nr][nc] == 'R' || grid[nr][nc] == 'G') {
					route.add(new Node(nr, nc));
					rgvisited[nr][nc] = true;
					cnt++;
				}
			}
		}
		return cnt;		
	}
}
