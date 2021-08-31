import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static long B;
	static int[][] A; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		A = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[][] result = powerMatrix(B);
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				sb.append(result[r][c]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);		
	}

	private static int[][] powerMatrix(long num) {
		int[][] tempA = new int[N][N];
		int[][] preA = new int[N][N];
		int[][] mulA;
		
		
		if(num == 1) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					tempA[r][c] = A[r][c]%1000;
				}
			}
			return tempA;
		}
		
		if(num%2==0) {
			preA = powerMatrix(num/2);
			mulA = preA;
		} else {
			preA = powerMatrix(num-1);
			mulA = A;
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				for(int t=0; t<N; t++) {
					tempA[r][c]+=(preA[r][t]*mulA[t][c]);
				}
				tempA[r][c]%=1000;
			}
		}
		return tempA;
	}
}
