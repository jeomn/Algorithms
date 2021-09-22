import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[][] house;
	static int[] princess;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		house = new int[N+1][N+1];
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				house[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[N+1][N+1][3];
		dp[1][2][0] = 1;
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				if(house[r][c] == 1) continue;
				
				dp[r][c][0] += (dp[r][c-1][0] + dp[r][c-1][2]);
				dp[r][c][1] += (dp[r-1][c][1] + dp[r-1][c][2]);
				if(house[r-1][c]!=0 || house[r][c-1]!=0) continue;
				dp[r][c][2] += (dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2]);
			}
		}

		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
	}
}
