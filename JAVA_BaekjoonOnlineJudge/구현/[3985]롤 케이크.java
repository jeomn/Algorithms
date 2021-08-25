import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cake = new int[L];
		Arrays.fill(cake, -1);
		int expectPieces = 0, expectPerson = -1;
		int maxPieces = 0, maxPerson = -1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			if(expectPieces < to-from) {
				expectPieces = to-from;
				expectPerson = i+1;
			}
			int cnt = 0;
			for(int j=from; j<=to; j++) {
				if(cake[j] != -1) continue;
				cake[j] = i+1;
				cnt++;
			}
			if(maxPieces < cnt) {
				maxPieces = cnt;
				maxPerson = i+1;
			}		
		}
		System.out.println(expectPerson);
		System.out.println(maxPerson);
	}
}
