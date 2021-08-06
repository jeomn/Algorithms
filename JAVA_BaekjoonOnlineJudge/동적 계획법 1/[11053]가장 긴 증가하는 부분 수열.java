import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] numArr = new int[N];
		for(int i=0; i<N; i++)
			numArr[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N];
		int max = -1;
		for(int idx=0; idx<N; idx++) {
			dp[idx] = 1;	//자기 자신
			
			for(int i=0; i<idx; i++) {
				if(numArr[i]<numArr[idx] && dp[idx]<dp[i]+1)	//내 앞에 붙일 수 있는 앞 친구들 검색
					dp[idx] = dp[i]+1;
			}
			max = Math.max(max,  dp[idx]);
		}
		System.out.println(max);
	
	}
	
}
