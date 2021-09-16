import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		Arrays.fill(dp[1], 1);
		for(int i=1; i<=N; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<=j; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j]%=10007;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<10; i++) {
			sum +=dp[N][i];
		}
		System.out.println(sum%10007);
		//System.out.println(Arrays.stream(dp[N]).sum()%10007);	//이것도 
	}
}
