import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int N = input.length();
		int R = 0;
		for(int r=1; r<N; r++) {
			if(N%r == 0 && r<=(N/r))
				R = Math.max(R, r);
		}
		int C = N/R;
		
		char[][] field = new char[R][C];
		int idx = 0;
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				field[r][c] = input.charAt(idx++);
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				sb.append(field[r][c]);
			}
		}
		System.out.println(sb);
	}
}
