import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxNum = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int sum = cards[i]+cards[j]+cards[k];
					if(sum>M) continue;
					maxNum = Math.max(maxNum, sum);
				}
			}
		}
		System.out.println(maxNum);
	}
}
