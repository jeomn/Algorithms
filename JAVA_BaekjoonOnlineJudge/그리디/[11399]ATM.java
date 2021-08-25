import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		int tempTime = 0, totalTime = 0;
		for(int i=0; i<N; i++) {
			tempTime += time[i];
			totalTime += tempTime;
		}
		System.out.println(totalTime);
	}
}
