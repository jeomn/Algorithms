import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_Bakery {
	
	static int R, C, cnt;
	static char[][] field;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {1, 1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		field = new char[R][C];
		for(int r=0; r<R; r++) {
			 field[r] = br.readLine().toCharArray();
		}
		
		cnt = 0;
		for(int r=0; r<R; r++) {
			field[r][0] = 'x';
			findPipeLine(r, 0);
		}
		System.out.println(cnt);

	}

	private static boolean findPipeLine(int row, int col) {
		if(col==C-1) {
			cnt++;
			return true;
		}
		
		for(int i=0; i<3; i++) {
			int nr = row+dx[i];
			int nc = col+dy[i];
			
			if(nr<0 || nr>=R) continue;
			if(field[nr][nc] == 'x') continue;
			
			field[nr][nc] = 'x';
			if(findPipeLine(nr, nc)) return true;
			
		}
		return false;
	}

}
