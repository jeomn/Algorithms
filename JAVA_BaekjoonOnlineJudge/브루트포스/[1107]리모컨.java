import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int channel, minCnt;
	static boolean[] buttons;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		channel =  Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		buttons = new boolean[10];
		Arrays.fill(buttons, true);
		if(n!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int b = Integer.parseInt(st.nextToken());
				buttons[b] = false;
			}
		}

		minCnt = Math.abs(channel-100);
		for(int i=0; i<1000000; i++) {
			int num = setNumber(i);
			if(num > 0) {
				int cnt = Math.abs(i-channel); 
				minCnt = Math.min(minCnt, cnt+num);
			}
		}
		System.out.println(minCnt);
	}

	private static int setNumber(int i) {
		if(i == 0) {
			if(buttons[i])
				return 1;
			else
				return 0;
		}
		
		int n = i;
		int cnt = 0;
		while(n>0) {
			if(!buttons[n%10]) {
				return 0;
			}
			n/=10;
			cnt++;
		}
		return cnt;
	}
}
