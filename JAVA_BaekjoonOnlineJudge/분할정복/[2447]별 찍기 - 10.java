import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	static int N;
	static char[][] field;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		field = new char[N][N];
		setStar(0, 0, N, false);
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(field[r][c]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
	}

	private static void setStar(int x, int y, int n, boolean flag) {
		if(flag) {
			for(int r=x; r<x+n; r++) {
				for(int c=y; c<y+n; c++) {
					field[r][c] = ' ';
				}
			}
			return;
		} else if(n==1) {
			field[x][y] = '*';
			return;
		}
		
		int size = n/3, count = 0;
		for(int r=x; r<x+n; r+=size) {
			for(int c=y; c<y+n; c+=size) {
				count++;
				if(count == 5) setStar(r, c, size, true);
				else setStar(r, c, size, false);
			}
		}
	}
}
