import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			boolean[] door = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1)
					door[i] = true; 
			}
			
			int idx = -1, count = 0;
			while(idx < N-1) {
				boolean moveFlag = false;
				for(int i=1; i<=D; i++) {
					if(idx+i >= N) continue;
					if(door[idx+i]) {
						moveFlag = true;
						idx += i;
						break;
					}
				}
				if(!moveFlag) {
					count++;
					idx+=D;
				}
			}
			
			System.out.println("#"+test+" "+count);
		}
	}
}
