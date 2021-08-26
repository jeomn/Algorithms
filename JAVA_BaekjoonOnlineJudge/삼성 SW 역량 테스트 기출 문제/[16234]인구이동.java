import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, L, R;
	static int[][] population;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		population = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				population[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0, unionFlag;
		while(true) {
			visited = new boolean[N][N];

			unionFlag = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(visited[r][c]) continue;
					unionFlag += movePopulation(r, c);
				}
			}
			if(unionFlag == 0) break;
			day++;
		}
		
		System.out.println(day);
	}

	private static int movePopulation(int x, int y) {
		Queue<int[]> route = new LinkedList<>();
		LinkedList<int[]> union = new LinkedList<>();
		int unionNum = 1, unionSum = population[x][y];
		route.add(new int[] {x, y});
		visited[x][y] = true;
		union.add(new int[] {x, y});
		
		while(!route.isEmpty()) {
			int[] node = route.poll();
			int r = node[0];
			int c = node[1];
			
			for(int i=0; i<4; i++) {
				int nr = r+dx[i];
				int nc = c+dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
				
				int differ = Math.abs(population[r][c] - population[nr][nc]);
				if(differ < L || R < differ) continue;
				
				route.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				
				union.add(new int[] {nr, nc});
				unionNum += 1;
				unionSum += population[nr][nc];
			}
		}
		
		if(unionNum == 1) return 0;
		int separateUnion = unionSum/unionNum;
		for(int[] node:union) {
			population[node[0]][node[1]] = separateUnion;
		}
		return 1;
	}
}
