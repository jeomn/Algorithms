import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[][] maze;
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for(int r=0; r<N; r++) {
			char[] temp = br.readLine().toCharArray();
			for(int c=0; c<M; c++) {
				maze[r][c] = temp[c]-'0';
			}
		}
		
		int result = findRoute(new Node(0, 0));
		System.out.println(result);
	}

	private static int findRoute(Node start) {
		Deque<Node> route = new LinkedList<>();
		int[][] visited = new int[N][M];
		for(int r=0; r<N; r++) {
			Arrays.fill(visited[r], -1);
		}
		route.add(start);
		visited[0][0] = 0;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!route.isEmpty()) {
			Node node = route.poll();
			
			for(int i=0; i<4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(visited[nx][ny] != -1) continue;
				
				if(maze[nx][ny] == 0) {
					route.addFirst(new Node(nx, ny));
					visited[nx][ny] = visited[node.x][node.y];
				} else {
					route.addLast(new Node(nx, ny));
					visited[nx][ny] = visited[node.x][node.y]+1;
				}
			}
		}
		return visited[N-1][M-1];
	}
}
