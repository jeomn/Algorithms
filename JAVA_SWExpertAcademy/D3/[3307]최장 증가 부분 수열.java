import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[N];
			dp[0] = 1;
			for(int i=1; i<N; i++) {
				dp[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[j] < arr[i] && dp[i] <= dp[j]) {
						dp[i] = dp[j]+1;
					}
				}
			}
			System.out.printf("#%d %d%n", test, Arrays.stream(dp).max().getAsInt());	
		}
	}
}
