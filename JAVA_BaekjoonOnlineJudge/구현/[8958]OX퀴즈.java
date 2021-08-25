import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			String input = br.readLine();
			int cnt = 0, score = 0;
			for(int idx=0; idx<input.length(); idx++) {
				char answer = input.charAt(idx);
				if(answer == 'O')
					cnt++;
				else
					cnt = 0;
				score += cnt;
			}
			System.out.println(score);
		}
	}
}
