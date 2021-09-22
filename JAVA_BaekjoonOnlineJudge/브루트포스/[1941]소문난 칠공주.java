import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	
	static int princessCnt;
	static char[][] classroom;
	static int[] princess;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		classroom = new char[5][5];
		for(int r=0; r<5; r++) {
			classroom[r] = br.readLine().toCharArray();
		}
		
		princess = new int[7];
		visited = new boolean[5][5];
		setPrincess(0, 0, 0);
		
		System.out.println(princessCnt);
	}
	
	
	private static void setPrincess(int cnt, int idx, int somCnt) {
		if(cnt == 7) {
			if(somCnt < 4) return;
			if(checkConnect()) princessCnt++;
			return;
		}
		
		for(int i=idx; i<25; i++) {
			if(visited[i/5][i%5]) continue;
			princess[cnt] = i;
			visited[i/5][i%5] = true;
			if(classroom[i/5][i%5] == 'S') setPrincess(cnt+1, i, somCnt+1);
			else setPrincess(cnt+1, i, somCnt);
			
			visited[i/5][i%5] = false;
		}
	}


	private static boolean checkConnect() {
		int startX=-1, startY=-1;
		find: for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				if(visited[r][c]) {
					startX=r;
					startY=c;
					break find;
				}
			}
		}
		
		Queue<int[]> route = new LinkedList<>();
		boolean[][] checkVisited = new boolean[5][5];
		route.add(new int[] {startX, startY});
		checkVisited[startX][startY] = true;
		
		int cnt = 1;
		while(!route.isEmpty()) {
			int[] node = route.poll();
			int x = node[0];
			int y = node[1];
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
				if(checkVisited[nx][ny] || !visited[nx][ny]) continue;
				
				checkVisited[nx][ny] = true;
				route.add(new int[] {nx, ny});
				cnt++;
			}
		}
		
		if(cnt == 7) return true;
		else return false;
	}
}
