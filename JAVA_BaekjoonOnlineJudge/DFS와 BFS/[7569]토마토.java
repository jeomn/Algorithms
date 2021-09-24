import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_Tomatoes {
	
	static int N, M, H;
	static int[][][] box;
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[N][M][H];
		LinkedList<int[]> tomato = new LinkedList<>();
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					box[r][c][h] = Integer.parseInt(st.nextToken());
					if(box[r][c][h] == 1) tomato.add(new int[] {r, c, h});
				}
			}
		}
		
		int day = ripenTomatoes(tomato);
		check: for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(box[r][c][h] == 0) {
						day = -1;
						break check;
					}
				}
			}
		}
		System.out.println(day);
	}
	
	
	private static int ripenTomatoes(LinkedList<int[]> start) {
		Queue<int[]> route = start;
		
		int day = 0;
		while(!route.isEmpty()) {
			int[] coord = route.poll();
			int r = coord[0];
			int c = coord[1];
			int h = coord[2];
			
			for(int i=0; i<6; i++) {
				int nr = r+dx[i];
				int nc = c+dy[i];
				int nh = h+dz[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M || nh<0 || nh>=H) continue;
				if(box[nr][nc][nh] != 0) continue;
				
				route.add(new int[] {nr, nc, nh});
				box[nr][nc][nh] = box[r][c][h]+1;
				day = Math.max(day, box[nr][nc][nh]-1);
			}
		}		
		
		return day;
	}
}
