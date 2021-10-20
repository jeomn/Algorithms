import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N, K;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[201][201];
		for(int i=0; i<=K; i++) {
			dp[i][0] = 1;
		}
		for(int i=1; i<=K; i++) {
			for(int j=1; j<=N; j++) {
				dp[i][j] = (dp[i][j-1]+dp[i-1][j])%1000000000;
			}
		}
		System.out.println(dp[K][N]);
	}
}
