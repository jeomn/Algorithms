import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M;
	static int[][] lab, labTemp;
	static ArrayList<int[]> virus;
	static ArrayList<int[]> zeros;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int snum = 0;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		virus = new ArrayList<>();
		zeros = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				lab[r][c] = temp;
				if(temp==2)
					virus.add(new int[]{r, c});
				else if(temp==0)
					zeros.add(new int[] {r, c});
			}
		}
		
		combBlock(0, 0, new int[3]);	//벽 세우기, 바이러스 확산
		System.out.println(snum);
	}
	
	
	public static void combBlock(int cnt, int start, int[] comb) {
		if(cnt == 3) {
			labTemp = new int[N][M];
			for(int r=0; r<N; r++)
				labTemp[r] = lab[r].clone();
			
			for(int i=0; i<3; i++) {
				int[] zeroTemp = zeros.get(comb[i]);
				int x = zeroTemp[0], y = zeroTemp[1];
				labTemp[x][y] = 1;
			}
			spreadVirus(labTemp);
			return;
		}
		
		for(int i=start; i<zeros.size(); i++) {
			comb[cnt] = i;
			combBlock(cnt+1, i+1, comb);
		}
	}
	
	
	public static void spreadVirus(int[][] map) {
		Queue<int[]> q = new LinkedList<>(virus);
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0], y = node[1];
			
			for(int idx=0; idx<4; idx++) {
				int nx = x+dx[idx];
				int ny = y+dy[idx];
				
				if(nx<0 || N<=nx || ny<0 || M<=ny) continue;
				if(map[nx][ny] != 0) continue;
				
				map[nx][ny] = 2;
				q.add(new int[]{nx, ny});
			}			
		}
		snum = Math.max(snum,  findSafeZone(map));
	}
	
	
	public static int findSafeZone(int[][] map) {
		int count=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) count++;
			}
		}
		return count;
	
	}
	
}
