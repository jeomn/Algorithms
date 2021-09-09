import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	static int N, K;
	static char[][] field;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		field = new char[N][2*N-1];
		for(int i=0; i<N; i++) {
			Arrays.fill(field[i], ' ');
		}
		setStar(N, 0, 0);
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<2*N-1; c++) {
				sb.append(field[r][c]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}


	private static void setStar(int n, int row, int col) {
		if(n==3) {
			field[row][col+2] = '*';
			field[row+1][col+1] = field[row+1][col+3] = '*';
			Arrays.fill(field[row+2], col, col+5, '*');
			return;
		}
		
		int mid = n/2;
		setStar(mid, row, col+mid);
		setStar(mid, row+mid, col);
		setStar(mid, row+mid, col+n);
	}
}
