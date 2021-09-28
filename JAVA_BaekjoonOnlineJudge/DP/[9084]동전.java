import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] coins = new int[N];
			for(int i=0; i<N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			int money = Integer.parseInt(br.readLine());
			
			int[] dp = new int[money+1];
			dp[0] = 1;
			for(int c=0; c<N; c++) {
				int coin = coins[c];
				for(int i=coin; i<money+1; i++) {
					dp[i] += dp[i-coin];
				}
			}
			System.out.println(dp[money]);
		}
	}
}
