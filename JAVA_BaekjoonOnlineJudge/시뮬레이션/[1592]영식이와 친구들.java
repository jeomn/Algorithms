import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] ballCnt = new int[N];
		ballCnt[0]++;
		int idx = 0, cnt = 0;
		while(true) {
			if(ballCnt[idx] == M)
				break;
			
			if(ballCnt[idx]%2 == 0) {
				idx = ((idx-L)+N)%N;
			}else {
				idx = (idx+L)%N;
			}
			
			ballCnt[idx]++;
			cnt++;
		}
		System.out.println(cnt);
	}
}
