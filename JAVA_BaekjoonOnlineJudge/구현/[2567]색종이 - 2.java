import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int[][] field;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		field = new int[101][101];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int r=x; r<x+10; r++) {
				for(int c=y; c<y+10; c++) {
					field[r][c]++;
				}
			}
		}
		
		int cnt = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};	
		for(int r=0; r<101; r++) {
			for(int c=0; c<101; c++) {
				if(field[r][c] != 0) {
					for(int i=0; i<4; i++) {
						int nr = r+dx[i];
						int nc = c+dy[i];
						
						if(nr<0 || nr>=101 || nc<0 || nc>=101) continue;
						if(field[nr][nc] == 0)
							cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
