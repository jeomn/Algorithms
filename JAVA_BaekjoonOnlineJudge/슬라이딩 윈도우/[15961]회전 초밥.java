import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[N];
		for(int i=0; i<N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		int[] sushi = new int[d+1];
		
		int eat = 0;
		for(int i=0; i<k; i++) {
			if(sushi[belt[i]] == 0) eat++;
			sushi[belt[i]]++;
		}
		
		int maxCnt = eat;
		
		for(int i=1; i<N; i++) {
			if(maxCnt <= eat) {
				if(sushi[c] == 0) maxCnt = eat+1;
				else maxCnt = eat;
			}
			
			sushi[belt[i-1]]--;
			if(sushi[belt[i-1]] == 0) eat--;
			
			if(sushi[belt[(i+k-1)%N]]==0) eat++;
			sushi[belt[(i+k-1)%N]]++;	
		}
		
		System.out.println(maxCnt);
	}
}
