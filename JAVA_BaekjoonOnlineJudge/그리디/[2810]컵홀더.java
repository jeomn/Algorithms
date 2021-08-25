import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[] theater = br.readLine().toCharArray();
		int cnt = 1;
		for(int i=0; i<N; i++) {
			char seat = theater[i];
			if(seat == 'S')
				cnt++;
			else {
				cnt++;
				i++;
			}
		}
		if(cnt > N) cnt = N; 
		System.out.println(cnt);
	}
}
